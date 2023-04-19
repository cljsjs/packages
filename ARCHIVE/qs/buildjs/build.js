var fs = require('fs')
var path = require('path')
var browserify = require('browserify')

browserify('./qs.js', { standalone: 'qs' })
  .bundle(writeFile('development/qs.inc.js'))

function writeFile(relativePath) {
  var filepath = path.join(__dirname, '/dist/cljsjs/qs/', relativePath)

  return function(err, buf) {
    if (err) {
      console.error(err)
      process.exit(1)
    }
    fs.writeFileSync(filepath, buf.toString())
    console.log(relativePath + ' generated')
  }
}
