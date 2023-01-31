# deploydokcerapi-server
In this repository, there is a Groovy file that builds an image of a Flask server that communicates with the Docker engine and uses a reverse proxy to enhance security.

#the server
This server, written in Flask, runs on port 5000 and has four routes.
http://localhost:5000 -> docker engine info
http://localhost:5000/req -> return client http request
http://localhost:5000/containers -> return all containers
http://localhost:5000/containers/running -> return all running containers

#reverse proxy server(nginx)
reverse proxy that run on port 80 and forwarding request to flask server

#deployment
 to deploy environment there are several requirements:
  * the jenkins agent is a windows machine
  * job-dsl pluggin 
  * create credentials in jenkins (the username must be amir2023,will be fixed in next update)
  * create freestyle poject and use my configuration (;
  
  
