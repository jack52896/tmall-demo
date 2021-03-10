package com.tmall_ssh.action;

public class Action4Parameter extends Action4Service{
			protected String  msg;
			protected int num;
			protected int oiid;
			protected int[] oiids;
			protected int total;
			
			public int getTotal() {
				return total;
			}

			public void setTotal(int total) {
				this.total = total;
			}

			public int[] getOiids() {
				return oiids;
			}

			public void setOiids(int[] oiids) {
				this.oiids = oiids;
			}

			public int getOiid() {
				return oiid;
			}

			public void setOiid(int oiid) {
				this.oiid = oiid;
			}

			public int getNum() {
				return num;
			}

			public void setNum(int num) {
				this.num = num;
			}

			public String getMsg() {
				return msg;
			}

			public void setMsg(String msg) {
				this.msg = msg;
			}
			
}
