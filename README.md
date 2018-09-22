## Run the Application

1. Open a terminal window and run the command: **SERVER_PORT=1234 ./gradlew bootRun**

2. Open another terminal window and run the command: **SERVER_PORT=6789 ./gradlew bootRun**

3. Open a web browser and go to URL: **http://localhost:1234**

4. Refresh the page several times and you should see the hit count increases incrementally

5. Open another tab in the same browser and go to URL: **http://localhost:6789**

6. You should see that the session id is the same and the hit count has incremented.