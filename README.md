
# dlk-auditing-test-harness

Service used to test local snapshots of boostrap-play. 

#### Workflow for getting play-auditing changes into dlk-auditing-test-harness:
- change play-auditing library
- sbt publishLocal
- change boostrap-play to use the play-auditing local snapshot
- change dlk-auditing-test-harness AppDependencies to use the boostrap-play snapshot

Run dlk-auditing-test-harness
```
sbt run
```

### Testing play-auditing library
#### Observing all the side effects of datastream responding with 400 to play-auditing
- download [mitmproxy](https://mitmproxy.org/downloads/) and start it using:
```
./mitmproxy --mode reverse:http://localhost:9999 --listen-port 8100
```
- from the datastream project use the docker-compose file for starting up rabbitMQ
```
docker-compose -f docker-compose.yaml up
```
- start datastream on port 9999 by modifying the run.sh in the datastream project
```
-Dhttp.port=9999
```
- run dlk-auditing-test-harness 
```
sbt run
```
- while in mitmproxy, use "i" to bring up the intercept prompt and type in "audit". This will intercept all requests from
dlk-auditing-test-harness to datastream
- use curl for call dlk-auditing-test-harness
```
curl localhost:9000/dlk-auditing-test-harness
```
- in mitmproxy, hit "a" to allow the request to go through, and then "e" followed by "c" to bring up the prompt for changing
the status code of the response. Change it to 400 for instance to see a Bad Request being returned to dlk-auditing-test-harness
