package parcinfo.util;



public class SystemInfo {
	
	public String getOsName() {
		return System.getProperty("os.name");
	}
	
	public String getOsVersion() {
		return System.getProperty("os.version");
	}
	
	public long getMaxMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.maxMemory()/1024/1024;
	}
	
	public long getFreeMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.freeMemory()/1024/1024;
	}
	
	public long getUsingMemory() {
		return (getMaxMemory() - getFreeMemory());
	}
	
	public String getAllInfo() {
		String info = "";
		info = info.concat("OS:"+getOsName()+";;");
		info = info.concat("MaxMemory:"+getMaxMemory()+";;");
		info = info.concat("FreeMemory:"+getFreeMemory()+";;");
		info = info.concat("UsingMemory:"+getUsingMemory()+";;");
		return info;
	}
}
