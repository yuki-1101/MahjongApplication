package model;

import java.util.ArrayList;
import java.util.List;

public class Role {
	private int markPoint;

	public static List<String> roleCheck(List<String> tehaiList, String tehai) {
		List<String> roleList = new ArrayList<>();
		List<String> checkList = new ArrayList<>();
		Role role = new Role();
		tehaiList.add(tehai);
		roleList = Yakuman.yakumanCheck(tehaiList);
		if(roleList.size() > 0) {
			return roleList;
		}
		checkList.add(role.tannyaoCheck(tehaiList));
		checkList.add(role.sevenPairsCheck(tehaiList));
		checkList.add(role.someteCheck(tehaiList));
		checkList.add(role.toitoihoCheck(tehaiList));
		checkList.add(role.chantaCheck(tehaiList));
		checkList.add(role.ipeikouCheck(tehaiList));
		role.insertList(roleList,checkList);
		return roleList;
	}

	private void insertList (List<String> outList,List<String> inList) {
		for(String name:inList) {
			if(!name.equals("")) {
				outList.add(name);
			}
		}
		if(outList.size() == 0) {
			outList.add("役なし");
		}
	}
	private String tannyaoCheck(List<String> tehaiList){
		String name = "";
		for(int i = 0; i < tehaiList.size(); i++){
			int num = Integer.parseInt(tehaiList.get(i));
			if((num / 10 != 4)
			&& (num % 10 != 1)
			&& (num % 10 != 9))
			{
				if(i == 13) {
					name = "断么九";
					this.markPoint=+1;
				}
			} else {
				break;
			}
		}
		return name;
	}

	private String sevenPairsCheck(List<String> tehaiList) {
		String name = "";
		for(int i = 0; i < tehaiList.size(); i++) {
			if(tehaiList.get(i).equals(tehaiList.get(++i))) {
				if(i == tehaiList.size() - 1) {
					name = "七対子";
					this.markPoint=+2;
				}
			} else {
				break;
			}
		}
		return name;
	}

	private String allAtOnce(List<String> tehaiList) {    //一気通貫製作途中
		String name = "";
		boolean flag = false;
		for(int i = 0; i < tehaiList.size(); i++) {
			int num = Integer.parseInt(tehaiList.get(i));
			switch (num / 10) {
			case 3:
				flag = true;
				break;
			case 2:
				flag = true;
				break;
			case 1:
				flag = true;
				break;
			}
		}

		return name;
	}

	private String someteCheck(List<String> tehaiList) {

		String name = "";
		boolean manzuFlg = false;
		boolean souzuFlg = false;
		boolean pinzuFlg = false;
		boolean charaFlg = false;

		for(int i = 0; i < tehaiList.size(); i++) {
			int num = Integer.parseInt(tehaiList.get(i));
			if(num / 10 == 4) {
				charaFlg = true;

			} else if(num / 10 == 3) {
				pinzuFlg = true;
				if(souzuFlg || manzuFlg) {
					break;
				}

			} else if(num / 10 == 2) {
				souzuFlg = true;
				if(pinzuFlg || manzuFlg) {
					break;
				}

			} else {
				manzuFlg = true;
				if(souzuFlg || pinzuFlg) {
					break;
				}

			}
			if(i == tehaiList.size() -1) {
				if(charaFlg) {
					if(pinzuFlg) {
						name = "筒子混一色";
					} else if(souzuFlg) {
						name = "索子混一色";
					} else if(manzuFlg) {
						name = "萬子混一色";
					}
				} else {
					if(pinzuFlg) {
						name = "筒子清一色";
					} else if(souzuFlg) {
						name = "索子清一色";
					} else if(manzuFlg) {
						name = "萬子清一色";
					}
				}
			}
		}
		return name;
	}

	//チャンタメソッド
	private String chantaCheck(List<String> tehaiList) {
		//初期化処理
		String name = "";
		boolean charaFlg = false;
		boolean honrotoFlg = true;

		//手牌の確認
		for(int nCnt = 0; nCnt < tehaiList.size();) {
			//初期化設定
			int num1 = Integer.parseInt(tehaiList.get(nCnt));
			int num2 = Integer.parseInt(tehaiList.get(nCnt+1));
			int num3 = nCnt+2;

			//３枚目があるかの確認
			if(num3 < tehaiList.size()) {   //3枚目がある
				num3 = Integer.parseInt(tehaiList.get(num3));

			} else {   //３枚目がない
				num3 = 0;
			}

			//字牌チェック
			if(!charaFlg) {
				if((num1 / 10 == 4) || (num2 / 10 == 4) || (num3 / 10 == 4)) {
					charaFlg = true;
				}
			}

			//三枚目があるかによって処理が分岐
			if(num3 != 0) { //連番チェック
				if(!(((num1 % 10) == 1) && ((num2 % 10) == 2) && ((num3 % 10) == 3)
				||  ((num1 % 10) == 7) && ((num2 % 10) == 8) && ((num3 % 10) ==9))) {
					//連番じゃない
					if((num1 / 10) == 4) { //字牌チェック
						//字牌である
						if((num1 == num2) && (num1 == num3)) { //字牌が３枚あるか
							//字牌が３枚ある
							nCnt +=3;
						} else if(num1 == num2) { //字牌が２枚あるか
							//字牌が２枚ある
							nCnt +=2;
						} else {
							//字牌が一枚なので"チャンタ"になりえない、よって処理終了
							break;
						}
					} else if(num1 == num2) { //字牌ではない同じ牌のチェック
						if(num1 == num3) { //同じ牌が3枚ある
							if((nCnt+3)<tehaiList.size()) {
								int num4 = Integer.parseInt(tehaiList.get(nCnt+3));
								if((num1+1) == num4) {
									nCnt += 2;
								} else {
									nCnt += 3;
								}
							}
							nCnt += 3;
						} else { //同じ牌が2枚ある
							nCnt += 2;
						}
					} else {
						//役として成立していないので処理終了
						break;
					}
				} else {
					//連番なので３枚確定
					honrotoFlg = false;
					nCnt +=3;
				}

			} else if (num1 == num2) {
				//２枚なのでアタマ確定
				if(((num1 % 10)!=1)&&((num1 % 10)!=9)) {
					break;
				}
				nCnt +=2;
			}

			if(nCnt >= tehaiList.size()-1) {
				if(charaFlg) {
					if(honrotoFlg) {
						name = "混老頭";
					} else {
						name ="チャンタ";
					}

				} else {
					name = "純チャン";
				}
			}
		}

		return name;
	}

	private String toitoihoCheck(List<String> tehaiList) {
		String name = "";
		boolean twoPairFlag = false;
		for(int i = 0 ; i < tehaiList.size();i += 3){
			int listNum1 = Integer.parseInt(tehaiList.get(i));
			int listNum2 = Integer.parseInt(tehaiList.get(i+1));
			int listNum3 = i + 2;
			if(listNum3 < tehaiList.size()){
				listNum3 = Integer.parseInt(tehaiList.get(listNum3));
			} else {
				listNum3 = -1;
			}
			if(listNum1 == listNum2){
				if(!(listNum1 == listNum3)){
					if(twoPairFlag){
						break;
					} else {
						i--;
						twoPairFlag = true;
					}
				}
			} else {
				break;
			}
			if(i >= tehaiList.size()-3){
				name = "対々和";
				break;
			}
		}
			return name;
	}

	private String ipeikouCheck(List<String> tehaiList) {
		//初期値
		String name ="";
		boolean manzuFlg = false;
		boolean souzuFlg = false;
		boolean pinzuFlg = false;

		//手牌チェック
		for(int i = 0; i < tehaiList.size(); i+=6) {
			int num1 = Integer.parseInt(tehaiList.get(i));
			int num2 = Integer.parseInt(tehaiList.get(i+1));
			int num3 = Integer.parseInt(tehaiList.get(i+2));
			int num4 = Integer.parseInt(tehaiList.get(i+3));
			int num5 = Integer.parseInt(tehaiList.get(i+4));
			int num6 = Integer.parseInt(tehaiList.get(i+5));

			//牌の種類を分ける
			if(((num1 / 10) == 3)
				&& ((num2 / 10) == 3)
				&& ((num3 / 10) == 3)
				&& ((num4 / 10) == 3)
				&& ((num5 / 10) == 3)
				&& ((num6 / 10) == 3)){
					pinzuFlg = true;
			} else if(((num1 / 10) == 2)
				&& ((num2 / 10) == 2)
				&& ((num3 / 10) == 2)
				&& ((num4 / 10) == 2)
				&& ((num5 / 10) == 2)
				&& ((num6 / 10) == 2)) {
					souzuFlg = true;
			} else if(((num1 / 10) == 1)
				&& ((num2 / 10) == 1)
				&& ((num3 / 10) == 1)
				&& ((num4 / 10) == 1)
				&& ((num5 / 10) == 1)
				&& ((num6 / 10) == 1)) {
					manzuFlg = true;
			} else if(((num1 / 10) == 4)
				|| ((num2 / 10) == 4)
				|| ((num3 / 10) == 4)
				|| ((num4 / 10) == 4)
				|| ((num5 / 10) == 4)
				|| ((num6 / 10) == 4)){
					break;
			}
			/*if(num1 == num2) { //対子か判定する
				if((num1+1) == Integer.parseInt(tehaiList.get(i+2))
				&& ((num1+1) == Integer.parseInt(tehaiList.get(i+3)))
				&& ((num1+2) == Integer.parseInt(tehaiList.get(i+4)))
				&& ((num1+2) == Integer.parseInt(tehaiList.get(i+5)))) {

				}
				i+=2;
				pinzuCnt+=1;
			} else {
				i+=1;
			}*/

			if(pinzuFlg) {
				//対子かつ順子か判定する
				if(((num1 == num2)
				&& (num3 == num4)
				&& (num5 == num6))
				&& ((num1+1 == num3)
				&& (num1+2 == num5))){

				} else {
					break;
				}
			}
			if(souzuFlg) {
				if(((num1 == num2)
					&& (num3 == num4)
					&& (num5 == num6))
					&& ((num1+1 == num3)
					&& (num1+2 == num5))){

				} else {
					break;
				}
			}
			if(manzuFlg) {
				if(((num1 == num2)
					&& (num3 == num4)
					&& (num5 == num6))
					&& ((num1+1 == num3)
					&& (num1+2 == num5))){

				}
			} else {
				break;
			}
			//手牌が14牌あるかどうか
			if(i >= tehaiList.size()-2){
				name = "一盃口";
			}
		}
		return name;
	}

}