var fs = require('fs')
var path = require('path')
var browserify = require('browserify')

browserify('./iconv.js', { standalone: 'iconv' })
  .bundle(writeFile('development/iconv-lite.inc.js'))

browserify('./iconv.js', { standalone: 'iconv' })
  .transform({ global: true }, 'uglifyify')
  .bundle(writeFile('production/iconv-lite.min.inc.js'))

function writeFile(relativePath) {
  var filepath = path.join(__dirname, '/dist/cljsjs/iconv-lite/', relativePath)

  return function(err, buf) {
    if (err) {
      console.error(err)
      process.exit(1)
    }
    fs.writeFileSync(filepath, buf.toString())
    console.log(relativePath + ' generated')
  }
}
