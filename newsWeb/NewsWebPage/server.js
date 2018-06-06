var express = require('express');
var app = express();
var fs = require('fs');
var newsContent;

app.set('view engine', 'ejs');
app.get('/' ,function (req , res) {
   var contentFile =  fs.readFileSync(__dirname + '/content.json','utf8');
   var content = JSON.parse(contentFile.trim());
   res.render('index' , {firstTopic:content.first , firstArticle:content.second , secondTopic:content.third , secondArticle:content.fourth} );
 })

 app.get('/postnews' ,function(req , res){
    if(req.query['first'] !==undefined ){
        newsContent = req.query['first'];
        var contentFile =  fs.readFileSync(__dirname + '/content.json','utf8');
        var content = JSON.parse(contentFile.trim());
        content['first'] =newsContent;
        var writeStream = fs.createWriteStream(__dirname +"\\content.json");
 	    writeStream.write(JSON.stringify(content));  
    } 
    else if(req.query['second'] !== undefined){
       newsContent = req.query['second'];
       var contentFile =  fs.readFileSync(__dirname + '/content.json','utf8');
       var content = JSON.parse(contentFile.trim());
       content['second'] =newsContent; 
       var writeStream = fs.createWriteStream(__dirname +"\\content.json");
 	   writeStream.write(JSON.stringify(content));
    }
    else if(req.query['third'] !== undefined){
       newsContent = req.query['third'];
       var contentFile =  fs.readFileSync(__dirname + '/content.json','utf8');
       var content = JSON.parse(contentFile.trim());
       content['third'] =newsContent; 
       var writeStream = fs.createWriteStream(__dirname +"\\content.json");
 	   writeStream.write(JSON.stringify(content));   
    }
    else if(req.query['fourth'] !== undefined){
        newsContent = req.query['fourth'];
        var contentFile =  fs.readFileSync(__dirname + '/content.json','utf8');
        var content = JSON.parse(contentFile.trim());
        content['fourth'] =newsContent; 
        var writeStream = fs.createWriteStream(__dirname +"\\content.json");
         writeStream.write(JSON.stringify(content));
     }
    res.status(200);
    res.set({'Content-type': 'text/plain'});
    res.send("news updated") ; 
});

app.get('/postPage', function (req , res){
        
    res.sendFile(__dirname + '/postPage.html');
 });
 
 
 app.get('/home' , function(req , res){
     var page = fs.createReadStream(__dirname + "/index.ejs" , 'utf8');
          res.status(200);
          res.set({'Content-Type':'text/html'});
          page.pipe(res);
     
 });

 app.get('/getnews' , function(req , res){
     console.log("update clicked =" , newsContent);
     res.send(newsContent);
 });
     
app.listen(8080);