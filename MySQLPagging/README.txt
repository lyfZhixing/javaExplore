ʵ�ַ�ҳ��˼·��
	MySQL��ҳ��SQL��select * from torder limit ?,?
	��һ��������ҳ���һ�����������ݿ��е��±꣬�ڶ���������ҳ��Ҫ��ʾ�����ݼ�¼��
	�±�index = (ҳ��pageindex - 1) * ÿҳ��¼��pagesize
	ÿҳ��¼��pagesize ��ҳ�洫��
	��Ҫһ��Pagging�����࣬�����Ļ��������У�	
		//ҳ��
		private int pageindex;
		//ҳ����ʾ���ݼ�¼��
		private int pagesize;
		//��ҳ�� 
		private int pagemax;
		//�ܼ�¼��
		private int recordmax;
		//Ҫ��ѯ�Ķ��󼯺�
		private List<?> list;
		
	��ҳ����Ҫ���㣺
		pagemax = (recordmax%pagesize == 0)?(recordmax/pagesize):(recordmax/pagesize+1);
		
	ҳ�洫��pageindex��pagesize����̨����Pagging������ajax��success������ȡ��Pagging�е�����