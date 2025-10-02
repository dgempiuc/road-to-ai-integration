# Creator Command

Create a new Spring Boot module with controller and service classes.

## Usage
```
/creator <module-name>
```

## Task

You are tasked with creating a new Spring Boot module structure. Follow these steps:

1. **Input Validation**: The module name is provided as `$ARGUMENTS`. Ensure it's not empty.

2. **Create Package Structure**:
   - Create package: `io.denizg.$ARGUMENTS`
   - Create subpackages: `io.denizg.$ARGUMENTS.controller` and `io.denizg.$ARGUMENTS.service`

3. **Generate Controller Class**:
   - Location: `src/main/java/io/denizg/$ARGUMENTS/controller/${CapitalizedName}Controller.java`
   - The controller should:
     - Be annotated with `@RestController` and `@RequestMapping("/api/$ARGUMENTS")`
     - Autowire the corresponding service
     - Include basic CRUD endpoint methods (at minimum a GET endpoint)

4. **Generate Service Class**:
   - Location: `src/main/java/io/denizg/$ARGUMENTS/service/${CapitalizedName}Service.java`
   - The service should:
     - Be annotated with `@Service`
     - Include basic business logic methods

5. **File Creation**:
   - Create all necessary directories
   - Write both Java files with proper imports and structure
   - Follow Spring Boot best practices

6. **Naming Convention**:
   - Capitalize the first letter of `$ARGUMENTS` for class names
   - Use the exact `$ARGUMENTS` value for package names (lowercase)

Example: If `$ARGUMENTS` is "product", create:
- Package: `io.denizg.product`
- Controller: `io.denizg.product.controller.ProductController`
- Service: `io.denizg.product.service.ProductService`

**Important**:
- Do NOT create test files unless explicitly requested
- Use consistent code style matching the existing codebase
- Commit the changes with an appropriate message after creation
