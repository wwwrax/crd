package rakesh.carrental.model;

import java.time.LocalDateTime;

public class RentWindow {
	
	private LocalDateTime start = LocalDateTime.now();
	private LocalDateTime end = start.plusDays(1);
	
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	
	public Boolean isBefore(RentWindow reqRentWindow) {
		if(this.start.isBefore(reqRentWindow.getStart()) &&
				this.end.isBefore(reqRentWindow.getStart())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean isAfter(RentWindow reqRentWindow) {
		if(this.start.isAfter(reqRentWindow.getEnd()) &&
				this.end.isAfter(reqRentWindow.getEnd())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	@Override
	public String toString() {
		return "RentWindow [start=" + start + ", end=" + end + "]";
	}
	
}
