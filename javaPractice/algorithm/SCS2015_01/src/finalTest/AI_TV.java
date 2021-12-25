package finalTest;

public class AI_TV extends TV{
	private String aiName;

	public AI_TV(String aiName, int channel) {
		super(channel);
		this.aiName = aiName;
	}

	public void command(String callableName) {
		if (callableName.equals(aiName)) {
			System.out.println("주인님! 현재 채널은 " + super.get_channel() + "번");
			return;
		}
		System.out.println("주인님! 저는 "+callableName+"가 아니에요.");
	}
}
