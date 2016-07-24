package org.unidal.cat.plugin.transaction.reducer;

import org.unidal.cat.plugin.transaction.TransactionConstants;
import org.unidal.cat.spi.ReportPeriod;
import org.unidal.cat.spi.report.ReportReducer;
import org.unidal.helper.Dates;
import org.unidal.lookup.annotation.Named;

import org.unidal.cat.plugin.transaction.model.entity.Range;
import org.unidal.cat.plugin.transaction.model.entity.TransactionReport;

@Named(type = ReportReducer.class, value = TransactionConstants.NAME + ":" + TransactionWeeklyReducer.ID)
public class TransactionWeeklyReducer extends AbstractTransactionReducer implements ReportReducer<TransactionReport> {
	public static final String ID = WEEKLY;

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public ReportPeriod getPeriod() {
		return ReportPeriod.WEEK;
	}

	@Override
	protected int getRangeValue(TransactionReport report, Range range) {
		int day = Dates.from(report.getStartTime()).dayOfWeek();

		return day;
	}
}
