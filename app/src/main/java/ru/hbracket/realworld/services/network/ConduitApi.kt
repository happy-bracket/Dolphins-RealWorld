package ru.hbracket.realworld.services.network

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*
import ru.hbracket.realworld.services.network.dto.*
import ru.hbracket.realworld.services.network.dto.wrappers.*

/*
 * TODO: replace `@Header(AuthHeader) token: String` construct with a more precise
 * ```
 * data class Token(
 *   val type: String,
 *   val value: String
 * )
 * ```
 * For which it is possible to create type adapter
 */
interface ConduitApi {

    @POST("/api/users/login")
    fun authentificate(@Body body: UserWrapper<AuthDto>): Single<UserWrapper<UserDto>>

    @POST("/api/users")
    fun register(@Body body: UserWrapper<RegistrationDto>): Single<UserWrapper<UserDto>>

    @GET("/api/user")
    fun getCurrentUser(@Header(AuthHeader) token: String): Single<UserWrapper<UserDto>>

    @PUT("/api/user")
    fun updateUser(
        @Body body: UserWrapper<UpdateUserDto>,
        @Header(AuthHeader) token: String
    ): Single<UserWrapper<UserDto>>

    @GET("/api/profiles/{username}")
    fun getProfile(
        @Path("username") username: String,
        @Header(AuthHeader) token: String? = null
    ): Single<ProfileWrapper<ProfileDto>>

    @POST("/api/profiles/{username}/follow")
    fun followUser(
        @Path("username") target: String,
        @Header(AuthHeader) token: String
    ): Single<ProfileWrapper<ProfileDto>>

    @DELETE("/api/profiles/{username}/follow")
    fun unfollowUser(
        @Path("username") target: String,
        @Header(AuthHeader) token: String
    ): Single<ProfileWrapper<ProfileDto>>

    @GET("api/articles")
    fun articlesList(
        @Query("tag") tag: String? = null,
        @Query("author") author: String? = null,
        @Query("favorited") likedBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
        @Header(AuthHeader) token: String? = null
    ): Single<ArticlesWrapper<List<ArticleDto>>>

    @GET("api/articles/feed")
    fun articlesFeed(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
        @Header(AuthHeader) token: String
    ): Single<ArticlesWrapper<List<ArticleDto>>>

    @GET("api/articles/{slug}")
    fun getArticle(@Path("slug") articleSlug: String): Single<ArticleWrapper<ArticleDto>>

    @POST("api/articles")
    fun createArticle(
        @Body body: ArticleWrapper<CreateArticleDto>,
        @Header(AuthHeader) token: String
    ): Single<ArticleWrapper<ArticleDto>>

    @PUT("api/articles/{slug}")
    fun updateArticle(
        @Body body: ArticleWrapper<UpdateArticleDto>,
        @Header(AuthHeader) token: String
    ): Single<ArticleWrapper<ArticleDto>>

    @DELETE("api/articles/{slug}")
    fun deleteArticle(
        @Path("slug") articleSlug: String,
        @Header(AuthHeader) token: String
    ): Completable

    @POST("api/articles/{slug}/comments")
    fun commentArticle(
        @Path("slug") articleSlug: String,
        @Body body: CommentWrapper<PostCommentDto>,
        @Header(AuthHeader) token: String
    ): Single<CommentWrapper<CommentDto>>

    @GET("api/articles/{slug}/comments")
    fun getComments(
        @Path("slug") articleSlug: String,
        @Header(AuthHeader) token: String? = null
    ): Single<CommentsWrapper<List<CommentDto>>>

    @DELETE("api/articles/{slug}/comments/{id}")
    fun deleteComment(
        @Path("slug") articleSlug: String,
        @Path("id") commentId: Long,
        @Header(AuthHeader) token: String
    ): Completable

    @POST("api/articles/{slug}/favorite")
    fun likeArticle(
        @Path("slug") articleSlug: String,
        @Header(AuthHeader) token: String
    ): Single<ArticleWrapper<ArticleDto>>

    @DELETE("api/articles/{slug}/favorite")
    fun unlikeArticle(
        @Path("slug") articleSlug: String,
        @Header(AuthHeader) token: String
    ): Single<ArticleWrapper<ArticleDto>>

    @GET("api/tags")
    fun getTags(): Single<TagsWrapper<List<String>>>

    companion object {

        private const val AuthHeader = "Authorization"

    }

}