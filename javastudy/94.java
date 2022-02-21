  Scanner in =new Scanner(System.in);
		  System.out.println("문자하나 입력");
	       char ch = in.next().charAt(0);
	       
	       if (ch>='A' && ch<='Z') {
	    	   System.out.println("대문자");
	       }else if(ch>='a' && ch<='z') {
	    	   System.out.println("소문자");
	       }else if(ch>='0' && ch<='9') {
	    	   System.out.println("숫자");
	       }else if(ch>='가' && ch<='힣') {
	    	   System.out.println("한글");
	       }else if(ch=='#'|| ch=='@' || ch=='$' || ch=='&') {
	    	   System.out.println("특수문자");
	       }
