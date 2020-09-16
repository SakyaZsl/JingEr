package com.zlj.jinger.bean

data class ArticleVO(val children: List<Any>,
                     val courseId: Int,
                     val id: Int,
                     val name: String,
                     val order: Int,
                     val parentChapterId: Int,
                     val userControlSetTop: Boolean,
                     val visible: Int)