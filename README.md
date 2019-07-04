# Recommendation
基于Apache Mahout + Ansj实现的Spring Boot个性化新闻内容推荐系统

## 基于内容推荐： 
  **基于内容的推荐(Content-based Recommendation)** 是建立在项目的内容信息上做出推荐的，而不需要依据用户对项目的评价意见，更多地需要用机器学习的方法从关于内容的特征描述的事例中得到用户的兴趣资料。在基于内容的推荐系统中，项目或对象是通过相关的特征的属性来定义，系统基于用户评价对象 的特征，学习用户的兴趣，考察用户资料与预测项目的相匹配程度。用户的资料模型取决于所用学习方法，常用的有决策树、神经网络和基于向量的表示方法等。基于内容的用户资料是需要有用户的历史数据，用户资料模型可能随着用户的偏好改变而发生变化。

## 协同过滤推荐： 
  **协同过滤推荐(Collaborative Filtering Recommendation)** 技术是推荐系统中应用最早和最为成功的技术之一。它一般采用最近邻技术，利用用户的历史喜好信息计算用户之间的距离，然后 利用目标用户的最近邻居用户对商品评价的加权评价值来预测目标用户对特定商品的喜好程度，系统从而根据这一喜好程度来对目标用户进行推荐。协同过滤最大优 点是对推荐对象没有特殊的要求，能处理非结构化的复杂对象，如音乐、电影。
  协同过滤是基于这样的假设：为一用户找到他真正感兴趣的内容的好方法是首先找到与此用户有相似兴趣的其他用户，然后将他们感兴趣的内容推荐给此用户。其基本 思想非常易于理解，在日常生活中，我们往往会利用好朋友的推荐来进行一些选择。协同过滤正是把这一思想运用到电子商务推荐系统中来，基于其他用户对某一内容的评价来向目标用户进行推荐。
  基于协同过滤的推荐系统可以说是从用户的角度来进行相应推荐的，而且是自动的，即用户获得的推荐是系统从购买模式或浏览行为等隐式获得的，不需要用户努力地找到适合自己兴趣的推荐信息，如填写一些调查表格等。

**基于用户的协同过滤:** 通过比较用户与用户间的相似度，找出相似用户喜好的物品并预测目标用户对对应物品的喜好，进而推荐给用户。 
**基于物品的协同过滤:** 与基于用户的协同过滤类似，通过找到物品与物品间的相似度来预测用户的喜好。 
**基于模型的协同过滤:** 采用机器学习的方法，通过离线计算实现推荐。通常它会首先根据历史数据，将数据集分成训练集和测试集两个数据集，使用训练集进行训练生成推荐模型，然后将推荐模型应用到测试集上，评估模型的优劣，如果模型到达实际所需要的精度，最后可以使用训练得到的推荐模型进行推荐（预测）。 

### 基于Ansj分词与TF-IDF的内容推荐 
**名词介绍:** 
  ***Ansj*** 是开源的中文分词器，是ICTLAS的Java版本，采用了Bigram+HMM分词模型，在Bigram分词的基础上，识别未登录词，以提高分词准确度。Ansj在易用性、稳定性、准确性及分词效率上都取得了不错的平衡。

  ***TF-IDF(term frequency–inverse document frequency)*** 是一种用于信息检索与数据挖掘的常用加权技术。TF意思是词频(Term Frequency)，IDF意思是逆文本频率指数(Inverse Document Frequency)。TF-IDF是一种统计方法，用以评估字词对于一个文件集或一个语料库中的其中一份文件的重要程度。字词的重要性随着它在文件中出现的次数成正比增加，但同时会随着它在语料库中出现的频率成反比下降。TF-IDF加权的各种形式常被搜索引擎应用，作为文件与用户查询之间相关程度的度量或评级。除了TF-IDF以外，因特网上的搜索引擎还会使用基于链接分析的评级方法，以确定文件在搜寻结果中出现的顺序。
  
![头像](https://github.com/ma0otong/Recommendation/blob/master/img/cb.jpg)

### 基于Apache Mahout的用户协同过滤 
**名词介绍:**
  ***Mahout*** 是 Apache Software Foundation（ASF） 旗下的一个开源项目，提供一些可扩展的机器学习领域经典算法的实现，旨在帮助开发人员更加方便快捷地创建智能应用程序。Mahout包含许多实现，包括聚类、分类、推荐过滤、频繁子项挖掘。此外，通过使用 Apache Hadoop 库，Mahout 可以有效地扩展到云中。虽然在开源领域中相对较为年轻，但 Mahout 已经提供了大量功能，特别是在集群和 CF 方面。Mahout 的主要特性包括：Taste CF。Taste 是 Sean Owen 在 SourceForge 上发起的一个针对 CF 的开源项目，并在 2008 年被赠予 Mahout。一些支持 Map-Reduce 的集群实现包括 k-Means、模糊 k-Means、Canopy、Dirichlet 和 Mean-Shift。

  ***曼哈顿距离(Manhattan Distance)*** 是由十九世纪的赫尔曼·闵可夫斯基所创词汇 ，是种使用在几何度量空间的几何学用语，用以标明两个点在标准坐标系上的绝对轴距总和。

  ***欧几里得距离*** 或欧几里得度量是欧几里得空间中两点间“普通”（即直线）距离。使用这个距离，欧氏空间成为度量空间。相关联的范数称为欧几里得范数。

  ***似然比(likelihood ratio, LR)*** 是反映真实性的一种指标，属于同时反映灵敏度和特异度的复合指标。

  在统计学中，***皮尔逊相关系数(Pearson correlation coefficient)*** ，又称皮尔逊积矩相关系数（Pearson product-moment correlation coefficient，简称 PPMCC或PCCs），是用于度量两个变量X和Y之间的相关（线性相关），其值介于-1与1之间。

  在统计学中, 以查尔斯·斯皮尔曼命名的***斯皮尔曼等级相关系数*** ，即spearman相关系数，经常用希腊字母ρ表示。 它是衡量两个变量的依赖性的 非参数 指标。 它利用单调方程评价两个统计变量的相关性。 如果数据中没有重复值， 并且当两个变量完全单调相关时，斯皮尔曼相关系数则为+1或−1。

  ***Tanimoto Coefficient*** 主要用于计算符号度量或布尔值度量的个体间的相似度。

  ***余弦相似度*** ，又称为余弦相似性，是通过计算两个向量的夹角余弦值来评估他们的相似度。余弦相似度将向量根据坐标值，绘制到向量空间中，如最常见的二维空间。

  ***K最近邻(k-Nearest Neighbor，KNN)*** 分类算法，是一个理论上比较成熟的方法，也是最简单的机器学习算法之一。该方法的思路是：如果一个样本在特征空间中的k个最相似(即特征空间中最邻近)的样本中的大多数属于某一个类别，则该样本也属于这个类别。
