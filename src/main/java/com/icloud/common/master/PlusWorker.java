package com.icloud.common.master;

import com.icloud.model.redEnvelope.FansSendRecord;

/**
 * @filename      : PlusWorker.java
 * @description   : 
 * @author        : zdh
 * @create        : 2017年7月25日 下午4:54:23   
 * @copyright     : zhumeng.com@multitask
 *
 * Modification History:
 * Date             Author       Version
 * --------------------------------------
 */
public class PlusWorker extends Worker {

	@Override
	public Object handle(FansSendRecord input) {
		return input;
	}
}

