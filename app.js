const http = require ("http");
const express = require('express');
//const morgan = require("morgan");
const cors = require ("cors");
const app = express();
const mongoose = require('mongoose');

//using port 3000
const port = 3000;

//tells express you want all data in json 
app.use(express.json())
//allows us to get nested json 
//app.use(express.urlencoded({extended: true}))
//app.use(morgan('dev'))
app.use(cors());

//routes - pushes traffic to middleware  
const AuthRoute = require('./routes/Users')
app.use('/user', AuthRoute)

//start server
const server = http.createServer(app);
server.listen(port);
server.on('listening', ()  => {
	console.log('Server is running & listening on port', port)
}); 

// mongo connection
const CONNECTION_URL = `mongodb+srv://admin:christian@capstonemongo.bxuei.mongodb.net/myFirstDatabase?retryWrites=true&w=majority`

mongoose.connect(CONNECTION_URL, {
  useNewUrlParser: true,
  useUnifiedTopology: true
})

//will print string to tell us mongo connection status 
mongoose.connection.on('connected', () => {
  console.log('Mongo DB has connected succesfully')
})
mongoose.connection.on('reconnected', () => {
  console.log('Mongo DB has reconnected')
})
mongoose.connection.on('error', error => {
  console.log('Mongo DB connection has an error', error)
  mongoose.disconnect()
})
mongoose.connection.on('disconnected', () => {
  console.log('Mongo DB connection is disconnected')
})

