
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
./mitmproxy --mode reverse:http://localhost:9999 --listen-port 8100 --set block_list='/audit/400'
```
*the block_list option allows you to define an intercept pattern of url "audit" and immediately return a status code of 400*

- from the datastream project use the docker-compose file for starting up rabbitMQ
```
docker-compose -f docker-compose.yaml up
```
- start datastream on port 9999 by modifying run.sh in the datastream project
```
-Dhttp.port=9999
```
- run dlk-auditing-test-harness
```
sbt run
```
- use curl for call dlk-auditing-test-harness
```
curl localhost:9000/dlk-auditing-test-harness
```
- in mitmproxy you should now see a 400 returned to dlk-auditing-test-harness
