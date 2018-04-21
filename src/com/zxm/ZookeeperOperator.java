package com.zxm;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

public class ZookeeperOperator extends AbstractZookeeper{

	private Stat pathExists(String path) throws KeeperException, InterruptedException {
		return zooKeeper.exists(path, false);
	}
	
	
	public void create(String path,byte[] data) throws KeeperException, InterruptedException {
		if(pathExists(path)==null) {
			zooKeeper.create(path, data, Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
		}
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		ZookeeperOperator z=new ZookeeperOperator();
		z.connect("192.168.200.11:2181");
		z.create("/my_test","bye".getBytes());
	}
}
