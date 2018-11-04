package base.app.ui.auth

import base.data.remote.Auth

class AuthImpl : Auth {
    override fun getAccessToken() = "token_value"
}