function delCookie(cname) { //매개변수로 쿠키명 받기
	
    if(getCookie(cname)){
        
    var now = new Date();
    now.setDate(now.getDate()-1); 

    document.cookie = cname+"=; expires="+now.toUTCString();
    }		
}


function getCookie(cname) {

    var cookies = document.cookie;
    var cookieArray = cookies.split(/;\s/);
    
    for (var i = 0; i < cookieArray.length; i++) {
        var nv = cookieArray[i].split("=");
        if (nv[0]==cname) { 
            return unescape(nv[1]); 
            
        }
    }		
    return null;
}



function setCookie(cname, cvalue, exdays) {
    
    var now = new Date();
    now.setDate(now.getDate()+exdays); 
//1970.1.1~ms 값
//now.setTime(	now.getTime + 1000*60*60*24*exdays	) 조작해나가면 된다
    document.cookie = cname+"="+cvalue+"; expires="+now.toUTCString();
    
    //domain = localhost
    //path = /webPro/javascript/days08 
}


function getAllCookies(){
    var cookies = document.cookie;		
    return cookies; //모든 쿠키 가져오겠다는 
}