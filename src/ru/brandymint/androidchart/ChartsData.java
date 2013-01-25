package ru.brandymint.androidchart;


public class ChartsData {


	/**
	 * Строка таблицы с данными
	 *
	 */
	public static class ChartItem {
		public final String title;
		public final double value;

		public ChartItem(String title, double value) {
			this.title = title;
			this.value = value;
		}
	}

	/**
	 * Диаграмма
	 *
	 */
	public static class Chart {
		/** Заголовок диаграммы */
		public final String title;

		/** Единица измерения */
		public final String unit;

		/** Значения */
		public final ChartItem items[];

		public Chart(String title, String unit, ChartItem items[]) {
			this.title = title;
			this.unit = unit;
			this.items = items;
		}
	}

	/**
	 * Реализация платных услуг населению в  2012 году
	 * http://chuvash.gks.ru/Bgd/Free/WEBSRO08/IssWWW.exe/Stg/220113/uslugi.htm
	 */
	public static final Chart CHART_PAID_SERVICES_2012 = new Chart(
			"Реализация платных услуг населению в  2012 году",
			"млн. рублей",
			new ChartItem[] {
					new ChartItem("бытовые", 3642.0),
					new ChartItem("транспортные", 5313.2),
					new ChartItem("связи", 5682.6),
					new ChartItem("жилищные", 2168.2),
					new ChartItem("коммунальные", 8821.5),
					new ChartItem("культуры", 370.4),
					new ChartItem("туристские", 541.2),
					new ChartItem("услуги гостиниц и  аналогичных средств размещения", 302.4),
					new ChartItem("физической культуры и спорта", 200.2),
					new ChartItem("медицинские", 2662.8),
					new ChartItem("санаторно-оздоровительные", 536.7),
					new ChartItem("ветеринарные", 65.1),
					new ChartItem("правового характера", 492.2),
					new ChartItem("системы образования", 2798.9),
					new ChartItem("социальные услуги, предоставляемые гражданам пожилого возраста и инвалидам", 130.1),
					new ChartItem("прочие", 555.6)

			}
			);
}
