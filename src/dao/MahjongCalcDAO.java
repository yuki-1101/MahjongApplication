package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MahjongCalcDAO {


	public static void main(String[] args) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/MahjongApplication","sa","1234")){

			//select文の準備
			String sql = "SELECT * FROM MahjongCalc WHERE 符 =50";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//select文を実行
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			while(rs.next()){
				String score = rs.getString("符");
				String transliteration = rs.getString("4翻(子)");
				System.out.println(score + "  " + transliteration);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}