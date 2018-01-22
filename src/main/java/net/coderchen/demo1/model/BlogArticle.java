package net.coderchen.demo1.model;

import java.util.Date;

public class BlogArticle {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.article_id
     *
     * @mbg.generated
     */
    private Integer articleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.article_name
     *
     * @mbg.generated
     */
    private String articleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.path
     *
     * @mbg.generated
     */
    private String path;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.article_id
     *
     * @return the value of blog_article.article_id
     *
     * @mbg.generated
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.article_id
     *
     * @param articleId the value for blog_article.article_id
     *
     * @mbg.generated
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.article_name
     *
     * @return the value of blog_article.article_name
     *
     * @mbg.generated
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.article_name
     *
     * @param articleName the value for blog_article.article_name
     *
     * @mbg.generated
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.create_time
     *
     * @return the value of blog_article.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.create_time
     *
     * @param createTime the value for blog_article.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.update_time
     *
     * @return the value of blog_article.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.update_time
     *
     * @param updateTime the value for blog_article.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.path
     *
     * @return the value of blog_article.path
     *
     * @mbg.generated
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.path
     *
     * @param path the value for blog_article.path
     *
     * @mbg.generated
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}