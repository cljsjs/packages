// @flow
/* eslint-disable import/no-dynamic-require */

import babel from "rollup-plugin-babel";
import commonjs from "rollup-plugin-commonjs";
import globby from "globby";
import pascalCase from "pascal-case";
import resolve from "rollup-plugin-node-resolve";
import uglify from "rollup-plugin-uglify";
import {minify} from "uglify-es";

// $FlowFixMe
const pkg = require(`./packages/socket/package.json`);

const plugins = {
  babel: babel({
    exclude: ["node_modules/**", "../../node_modules/**"],
    runtimeHelpers: true
  }),
  commonjs: commonjs({
    namedExports: {
      'node_modules/phoenix/priv/static/phoenix.js': [ 'Socket' ]
    }
  }),
  resolve: resolve(),
  uglify: uglify({}, minify)
};

const dirs = {
  input: "packages/socket/src",
  output: "dist",
  compat: "compat"
};

const getCjsAndEsConfig = fileName => ({
  input: `${dirs.input}/${fileName}`,
  output: [
    {file: `${dirs.output}/${fileName}`, format: "es"},
    {file: `${dirs.compat}/cjs/${fileName}`, format: "cjs"}
  ],
  plugins: [plugins.babel, plugins.uglify],
  sourcemap: true
});

const sources = globby.sync("**/*js", {cwd: dirs.input});

// eslint-disable-next-line no-unused-vars
const getUnscopedName = pkg => {
  const [scope, name] = pkg.name.split("/");

  return pascalCase(scope) + pascalCase(name);
};

export default [
  {
    input: `${dirs.input}/index.js`,
    output: {
      file: `${dirs.compat}/umd/index.js`,
      format: "umd"
    },
    name: pascalCase(getUnscopedName(pkg)),
    plugins: [plugins.babel, plugins.resolve, plugins.commonjs, plugins.uglify],
    sourcemap: true
  },
  ...sources.map(getCjsAndEsConfig)
];
