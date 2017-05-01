# Change Log
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/).

## [Unreleased]

## [20121119-2] - 2017-05-01
### Added
- Initiated the change log
- Added the minified version of the library
- Manually recreated the externals.js file from the unminified source, adding
  - Configuration knobs (Diff_Timeout, Diff_EditCost, Match_Threshold, Match_Distance, Patch_DeleteThreshold, Patch_Margin, Match_MaxBits)
  - Diff type constants (DIFF_DELETE, DIFF_INSERT, DIFF_EQUAL)
  - Regexes (nonAlphaNumericRegex_, whitespaceRegex_, linebreakRegex_, blanklineEndRegex_, blanklineStartRegex_)
  - Type annotations
