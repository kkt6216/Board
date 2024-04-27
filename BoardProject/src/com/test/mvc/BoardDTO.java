package com.test.mvc;

public class BoardDTO
{
	private int bd_id;
	private String bd_title, bd_content;
	private String fileName, filePath;
	
	
	public int getBd_id()
	{
		return bd_id;
	}
	public void setBd_id(int bd_id)
	{
		this.bd_id = bd_id;
	}
	public String getBd_title()
	{
		return bd_title;
	}
	public void setBd_title(String bd_title)
	{
		this.bd_title = bd_title;
	}
	public String getBd_content()
	{
		return bd_content;
	}
	public void setBd_content(String bd_content)
	{
		this.bd_content = bd_content;
	}
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getFilePath()
	{
		return filePath;
	}
	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}
	
	
	
}
