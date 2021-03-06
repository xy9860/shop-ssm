<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<script type="text/javascript" src="${shop}/jquery-easyui-1.5.1/jscharts.js"></script>
<script type="text/javascript">
	var myChart = new JSChart('chart_container', 'bar', '');
	myChart.setDataArray([ [ 'Jun-04', 22.5 ], [ 'Oct-04', 28 ],
			[ 'Feb-05', 32 ], [ 'Jun-05', 29 ], [ 'Oct-05', 36 ],
			[ 'Feb-06', 42 ], [ 'Jun-06', 47 ], [ 'Oct-06', 44 ],
			[ 'Feb-07', 49 ] ]);
	myChart.colorize([ '#44A622', '#A7B629', '#CAD857', '#E4DB7B', '#ECDE49',
			'#ECC049', '#EC9649', '#D97431', '#D95531' ]);
	myChart.setSize(600, 400);
	myChart.setBarValues(false);
	myChart.setBarSpacingRatio(45);
	myChart.setBarOpacity(1);
	myChart.setBarBorderWidth(0);
	myChart.setTitle('Home broadband penetration');
	myChart.setTitleFontSize(10);
	myChart.setTitleColor('#607985');
	myChart.setAxisValuesColor('#607985');
	myChart.setAxisNameX('月份', true);
	myChart.setAxisNameY('数量', true);
	myChart.setGridOpacity(0.8);
	myChart.set3D(true);
	myChart.draw();
</script>
</head>
<body>
	请选择报表的类型:
	<select id="sale">
		<option value="">年度销售报表</option>
		<option>季度销售报表</option>
		<option>月度销售报表</option>
	</select>
	查询的数量:
	<select id="number">
		<option value="5">5</option>
		<option value="10">10</option>
		<option value="20">20</option>
	</select>
	报表的类型:
	<select id="type">
		<option value="pie">饼状图</option>
		<option value="bar">柱状图</option>
		<option value="line">折线图</option>
	</select>
	<div id="chart_container">Loading chart...</div>
</body>

</html>