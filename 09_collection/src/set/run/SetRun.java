package set.run;

import set.service.SetService;

public class SetRun {
	public static void main(String[] args) {
		
		SetService service = new SetService();
		
//		service.test1();
//		service.test2();
//		service.test3();
//		service.test4();
		service.lottoNumberGenerator();
	}
}