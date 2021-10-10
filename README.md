# Forelesning 4: Http server

HTTP request ser ut

## Repeat av lecture 2

* [x] Maven
* [x] Github Actions
* [x] Working branch
* [x] Pull request
* [x] Test report (Maven (--fail-at-end
  - name: Publish test report
  uses: scacap/action-surefire-report@v1
  if: ${{ always () }}))

## Repeat av lecture 3: Socket, HTTP

* [x] Socket connects server
* [x] Status code
* [x] Header fields
* [x] Content-length
* [x] Message body

## TODAY: HttpServer

* [x] HttpServer should respond with 404
* [x] HttpServer should include request target in 404
* [x] Return a static content for /hello
* [x] Content-type
* [x] Return HTML file from disk
* [x] Return <form>
* [x] Process GET request for form

## Lecture 6:
* [ ] styling
* [ ] handle more than one request
* [ ] Feilhåndtering
* [ ] Refactor -> HttpMessage class
* [ ] Process POST request from form
* [ ] URL encoding
* [ ] Make exacutable JAR