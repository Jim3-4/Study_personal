package two;

public class DmbCellphoneExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DmbCellphone dmb=new DmbCellphone("자바폰","검정",10);
		
		System.out.println(dmb.model);
		System.out.println(dmb.color);
		
		System.out.println(dmb.channel);
		
		dmb.powerOff();
		dmb.bell();
		dmb.sendVoice("여보세요");
		
		dmb.changeChannelDmb(12);
	}

}
