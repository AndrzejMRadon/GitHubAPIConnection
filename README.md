# GitHub Repositories API

A simple Spring Boot 4.0.1 application in Java 25 that provides a REST API to fetch GitHub user repositories.

---

## Technologies

* Java 25
* Spring Boot 4.0.1
* Gradle (Kotlin DSL)
* Spring Web (`@RestController`)
* JUnit 5 + MockMvc (integration tests)
* GitHub API (`org.kohsuke:github-api`)

---

## Endpoint

### GET /github/repos

Returns a list of repositories for a given GitHub user (only non-forked) along with branches and the last commit SHA.

**Example response 200 OK:**

```json
[
  {
    "repositoryName": "Hello-World",
    "ownerLogin": "octocat",
    "listOfBranches": [
      {
        "name": "main",
        "lastCommitSha": "abc123def456"
      }
    ]
  }
]
```

**Example response 404 (non-existing user):**

```json
{
  "status": 404,
  "message": "User not found"
}
```

---

## Configuration

In the `application.yaml` file:

```yaml
spring:
  application:
    name: test
github:
  userName: octocat
  api:
    url: https://api.github.com
```

> Change `userName` to test different GitHub accounts.

---

## Running the application

```bash
./gradlew bootRun
```

The application will start on the default port `8080`.

---

## Integration tests

Tests are located in `src/test/java`.

* They call the `/github/repos` endpoint using `MockMvc`
* They verify:

  * 200 OK response and JSON structure for existing users
  * 404 response and `"User not found"` message for non-existing users

Running tests:

```bash
./gradlew test
```

> The tests are true integration-style tests: full Spring context, real controller calls, real GitHub API requests, no mocks for the service.

---

## Notes

* The application works as a proxy to the GitHub API
* Pagination, caching, and security are not implemented (as per the task requirements)
* The `ApiExceptionHandler` handles 404 responses for non-existing users
