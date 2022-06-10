/**
 *   cookie.js
 */


 function getAllCookies(){
    var cookies = document.cookie;
    return cookies;
 }
 
 function setCookie(cname, cvalue, expdays){
    var now = new Date();
    var day = now.getDate() +expdays;
    now.setDate(day);
 
    document.cookie = cname+"="+escape(cvalue)+"; expires="+now.toUTCString();
 }
 
 function getCookie(cname){
    var cookies = document.cookie; 
    var pattern =  /;\s/  ;
    var cookieArray = cookies.split(pattern);
     
     for (var i = 0; i < cookieArray.length; i++) {
       var cnv = cookieArray[i].split("=");
       cn = cnv[0];
       cv = cnv[1];
       if(cn == cname){
          $("#demo").html(unescape(cv));
          return unescape(cv);
       }//if
       
    }//for
    return null;
 }
 
 function delCookie(cname){
    var now = new Date();
    var day = now.getDate() -10;
    now.setDate(day);
    document.cookie = cname+"=; expires="+now.toUTCString();
    
 }
 
 
 
 
 
 
 