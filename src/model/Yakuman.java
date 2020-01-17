package model;

import java.util.ArrayList;
import java.util.List;

public class Yakuman {

	/*public static enum YakumanName{
		None(null),
		AllGreen("緑一色"),
		Kokushi("国士無双");

		private String name;

		private YakumanName(String name) {
			this.name = name;
		}
	}*/
	public static List<String> yakumanCheck(List<String> tehaiList) {
		List<String> roleList = new ArrayList<>();
		for(int i = 0; i < tehaiList.size(); i++) {
			int num = Integer.parseInt(tehaiList.get(i));
			boolean flag = true;
			//こういう書き方あるよ
			//緑一色
			if((num == 46)
			|| (num == 22)
			|| (num == 23)
			|| (num == 24)
			|| (num == 26)
			|| (num == 28))
			{
				if(i == 13) {
					roleList.add("緑一色");
				}
			} else {
				break;
			}
		}

//		//国士無双
//		if((tehaiList.equals("0"))
//			|| (tehaiList.equals("8"))
//			|| (tehaiList.equals("9"))
//			|| (tehaiList.equals("17"))
//			|| (tehaiList.equals("18"))
//			|| (tehaiList.equals("26"))
//			|| (tehaiList.equals("27"))
//			|| (tehaiList.equals("28"))
//			|| (tehaiList.equals("29"))
//			|| (tehaiList.equals("30"))
//			|| (tehaiList.equals("31"))
//			|| (tehaiList.equals("32"))
//			|| (tehaiList.equals("33"))) {
//
//			int count = 1;
//			for(int j = i + 1; j < tehaiList.size(); j++) {
//				if(tehaiList.get(i).equals(tehaiList.get(j))) {
//					count++;
//					if(count >= 2) {
//						flag = false;
//						break;
//					}
//				} else if(i == 13) {
//					roleList.add("国士無双");
//					return roleList;
//				}
//			}
		return roleList;
	}
}

