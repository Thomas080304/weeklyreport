package exer;

//"������棬����ɹ��"
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetFish {

	public static void main(String[] args) {
		String date1 = "1990/1/1"; // ��ʼ�������������ɹ����������
		String date2 = "1990/1/10"; // �ֶ����������
		long day = getQuot(date1, date2);// ����ֵ����ʱ���
		if ((day + 1) % 5 == 0 || (day + 1) % 5 == 4) {
			System.out.println("��������Ϣ�գ�����ɹɹ��");
		} else {
			System.out.println("����Ҫ�����������ˣ�");
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