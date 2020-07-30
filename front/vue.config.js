module.exports = {
  transpileDependencies: ["vuetify"],
  devServer: {
    proxy: {
      '/': {
        target: '//woowacourse.com:8080'
      }
    }
  }
}
