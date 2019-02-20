package exer;

//"三天打渔，两天晒网"
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetFish {

	public static void main(String[] args) {
		String date1 = "1990/1/1"; // 开始“三天打鱼两天晒网”的日期
		String date2 = "1990/1/10"; // 手动输入的日期
		long day = getQuot(date1, date2);// 传入值计算时间差
		if ((day + 1) % 5 == 0 || (day + 1) % 5 == 4) {
			System.out.println("今天是休息日，可以晒晒网");
		} else {
			System.out.println("今天要工作，打鱼了！");
		}

	}

	public static long getQuot(String time1, String time2) {
		long dayDistance = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			dayDistance = date2.getTime() - date1.getTime();
			dayDistance = dayDistance / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dayDistance;
	}

}