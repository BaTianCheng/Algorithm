package com.设计模式.命令模式;
//新建文件命令
public class CommandCreate implements Command {
	MakeFile makeFile;
	public CommandCreate(MakeFile makeFile) {
		this.makeFile = makeFile;
	}
	@Override
	public void execute(String name) throws Exception {
		makeFile.createFile(name);
	}
}
