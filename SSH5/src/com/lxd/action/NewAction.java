package com.lxd.action;

import javax.annotation.Resource;




import com.lxd.bean.News;

import com.lxd.dao.NewsDao;

public class NewAction extends SuperAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String s_pageNow;
	private NewsDao newsDao;
	private News news;
	private int pageNow=1;

	
	public String updateInput(){
		News news= (News) newsDao.findById(News.class, id);
		//##########################################
		request.put("news",news);
		return "news_updateInput_success";
	}
	public String delete(){
		
		//System.out.println("##########NewAction###delete##############################");
		//System.out.println("#########NewAction###delete#############################################admin#########"+id);
		
		try {
			newsDao.delById(News.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "news_delete_success";
		
	}
	public String update(){
		newsDao.update(news);
		return "news_update_success";
		
	}
	
	
	public String showContent(){
		
		news=(News) newsDao.findById(News.class, id);
//		String hql="from News where id='"+id+"'";
//		System.out.println("##@@@@@@ProjectAction######Project"+id);
//		System.out.println("##@@@@@@ProjectAction######hql"+hql);
		
	
		request.put("news",news);
		return "news_showContent_success";
	}
	public String showList(){
		//System.out.println("#####s_pageNow##@@@@@@@@#"+s_pageNow+"+##################");
		if(s_pageNow!=null)
		{
			pageNow=Integer.parseInt(s_pageNow);
			//System.out.println("#####pageNow##@@@@@@@@#"+pageNow+"+#######pageNow##########");
		}
		String hql="from News order by id";
		//System.out.println("########111111##NewAction###showList#####################NewAction#########");
		request.put("newsList",newsDao.excuteQueryByPage(hql, pageNow, 3));

		String hql1="select count(*) from News";
		int pageCount=newsDao.getPageCount(hql1, 3);
		//######Admin######PageCount
		
		int totalCount=newsDao.getTotalCount(hql1, 3);
		request.put("pageCount",pageCount);
		request.put("totalCount",totalCount);
		request.put("pageNow",pageNow);
		
		return "news_showList_success";
	}
	public String add(){
		
		System.out.println("##########NewAction###add##############################");
		//System.out.println("#########AdminAction###add#############################################NewAction#########");
		//String hql="from Admin where id='"+admin.getName()+"' and password='"+admin.getPassword()+"'";
		System.out.println("NewAction######NewAction######"+news.getTitle());
		System.out.println("NewAction######NewAction######"+news.getContent());
		newsDao.add(news);
		System.out.println("##########NewAction###add##############################");
		//System.out.println("##########NewAction###add##############################");
		return "news_add_success";
	}
	

	
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public NewsDao getNewsDao() {
		return newsDao;
	}
	
	@Resource
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getS_pageNow() {
		return s_pageNow;
	}
	public void setS_pageNow(String sPageNow) {
		s_pageNow = sPageNow;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
	
}
