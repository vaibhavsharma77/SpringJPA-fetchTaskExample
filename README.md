
# ASYNC TASK PROCESSING

Sometimes, we have to wait for a Third party endpoint to provide the result which is required in our application to do further processing .This can be processing of a document so to automate this process we can develope such small application to achieve our goal.
## Run Locally

Clone the project

```bash
  git clone https://github.com/vaibhavsharma77/SpringJPA-fetchTaskExample.git
```

Go to the project directory

```bash
  SpringJPA-fetchTaskExample and Import in IntellJ
```

Start the server

```bash
  hit http://localhost:9000/rest/post get api in browser to insert record in our table.
```

Checking Records in In Moemory Database 

```bash
 1.Hit the http://localhost:9000/h2-console with credentails as (username:sa ,password : password)
 2.The Number of times your hit the get endpoint mentioned above it produce different result each time(DONE,ERROR,OPEN)
```

## Tech Stack

**Skill:** Java,Rest Web Service,Spring boot and H2 as In Memory Database


