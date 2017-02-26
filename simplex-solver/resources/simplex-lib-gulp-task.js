// Javascript lib
gulp.task('js-lib', function() {
  var appConfig = _.pick(config, 'env');
  return combineWatch([
    //gulp.src(['src/index.js', 'src/equation.js']),
    gulp.src(['simplex-solver.inc.js']),
    browserify({
      debug: config.env.development,
      insertGlobals: true,
      insertGlobalVars: {
        config: function () {
          return JSON.stringify(appConfig);
        }
      }
    }),
    uglify(),
    gulp.dest('dist/lib')
  ]);
});