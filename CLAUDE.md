# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build and Run Commands

```bash
# Run the application
mvn spring-boot:run

# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=TarihUtilsTest

# Build the project
mvn clean install
```

The application runs on port **8079** by default.

## Architecture Overview

This is a Spring Boot 3.3.5 application using Java 21 that provides REST APIs for various utilities (date calculations, string operations, algorithms).

### Module Structure

The codebase follows a **modular package-by-feature** architecture. Each feature module is organized under `io.denizg.<module-name>`:

```
io.denizg/
├── <module-name>/
│   ├── controller/    # REST endpoints
│   └── service/       # Business logic
├── AlgorithmHelper.java  # Static algorithm utilities
└── Main.java         # Spring Boot application entry point
```

**Existing modules:**
- `tarih` - Date operations (e.g., calculating day differences)
- `string` - String operations (e.g., reversing strings)
- `dosya` - File operations (newly created)

### Configuration-Driven Endpoints

API paths are configured in `application.yml` under the `api.path` section, not hardcoded. Controllers read these paths via `@Value` annotations.

Example from `application.yml`:
```yaml
api:
  path:
    tarih:
      base: /tarih
      gun-farki: /gun-farki
```

### Code Standards

- **Dependency Injection**: Use constructor injection (final fields + constructor), NOT `@Autowired` field injection
- **Configuration**: Read paths and configurable strings from `application.yml`
- **API Pattern**: Controllers use `@RestController` + `@RequestMapping`, services use `@Service`

## Custom Slash Command

This repository includes a custom `/creator` command for scaffolding new modules:

```bash
/creator <module-name>
```

This creates:
1. Package structure: `io.denizg.<module-name>.{controller, service}`
2. Controller class with CRUD endpoints at `/api/<module-name>`
3. Service class with basic business logic
4. Uses constructor injection pattern

Do NOT commit changes when using `/creator` unless explicitly requested by the user.
