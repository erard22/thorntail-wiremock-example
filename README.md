# thorntail-wiremock-example
A small example project showing the use of [wiremock](http://wiremock.org/) for mocking surrounding services for development 
and reuses the same configuration for systemtests.

Here we have a wiremock configuration for a simple echo service

```json
{
  "request": {
    "method": "GET",
    "urlPattern": "/echo/([a-z]*)"
  },
  "response": {
    "status": 200,
    "body": "EchoResponse: {{request.path.[1]}}",
    "transformers": ["response-template"],
    "headers": {
      "Content-Type": "text/plain"
    }
  }
}
```

## Commands

### During develoment

```bash
# starting wiremock
mvn wiremock:run

# starting thorntail
mvn thorntail:run

# call the service
curl http://localhost:8080/hello/john

```

### Systemtests

This starts thorntail and wiremock before running the systemtest. Afterwards both will be shut down.

```bash
mvn verify
```
