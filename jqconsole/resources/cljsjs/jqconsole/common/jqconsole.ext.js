/**
 * @fileoverview Closure Compiler externs for jqconsole.js 2.12.0
 * @see http://replit.github.io/jq-console
 * @externs
 * @author Andrea Richiardi
 */

/**
 * @constructor
 * @param {(Element|jQuery|Document| Object.<string,
 *     (string|function(!jQuery.event=))>)=} header Text to print at the top of
 *     the console on reset. Optional. Defaults to an empty string.
 * @param {?string|undefined} prompt_label The label to show
 *     before the command prompt. Optional. Defaults to DEFAULT_PROMPT_LABEL.
 * @param {?string|undefined} prompt_continue_label The label to
 *     show before continuation lines of the command prompt. Optional. Defaults
 *     to DEFAULT_PROMPT_CONINUE_LABEL.
 * @param {?boolean|undefined} disable_auto_focus is a boolean indicating
 *     whether we should disable the default auto-focus behavior.
 * @return {!JQConsole}
 */
$.prototype.jqconsole = function(header, prompt_main, prompt_continue, disable_auto_focus) {};

/**
 * @constructor
 * @param {(jQuerySelector|Element|Object|Array.<Element>|jQuery|string|
 *     function())=} outer_container The DOM element into which the console is
 *     inserted.
 * @param {?string|undefined} header Text to print at the top of the console on
 * reset. Optional. Defaults to an empty string.
 * @param {?string|undefined} prompt_label The label to show
 *     before the command prompt. Optional. Defaults to DEFAULT_PROMPT_LABEL.
 * @param {?string|undefined} prompt_continue_label The label to
 *     show before continuation lines of the command prompt. Optional. Defaults
 *     to DEFAULT_PROMPT_CONINUE_LABEL.
 * @param {?boolean|undefined} disable_auto_focus is a boolean indicating
 *     whether we should disable the default auto-focus behavior.
 * @return {!JQConsole}
 */
function JQConsole (outer_container, header, prompt_label, prompt_continue_label, disable_auto_focus) {}

/**
 * @constructor
 * @return {!Ansi}
 */
function Ansi() {}

/*------------------------ Shortcut Methods ----------------------------- */

JQConsole.prototype.RegisterShortcut = function(key_code, callback) {};
JQConsole.prototype.UnRegisterShortcut = function(key_code, handler) {};

/*---------------------- END Shortcut Methods --------------------------- */

/*------------------------ Public Methods ----------------------------- */

JQConsole.prototype.ResetHistory = function() {};
JQConsole.prototype.ResetShortcuts = function() {};
JQConsole.prototype.ResetMatchings = function() {};
JQConsole.prototype.Reset = function() {};
JQConsole.prototype.GetHistory = function() {};
JQConsole.prototype.SetHistory = function(history) {};
JQConsole.prototype.GetColumn = function() {};
JQConsole.prototype.GetLine = function() {};
JQConsole.prototype.ClearPromptText = function(clear_label) {};
JQConsole.prototype.GetPromptText = function(full) {};
JQConsole.prototype.SetPromptText = function(text) {};
JQConsole.prototype.SetPromptLabel = function(main_label, continue_label) {};
JQConsole.prototype.UpdatePromptLabel = function() {};
JQConsole.prototype.Write = function(text, cls, escape) {};
JQConsole.prototype.Append = function(node) {};
JQConsole.prototype.Input = function(input_callback) {};
JQConsole.prototype.Prompt = function(history_enabled, result_callback, multiline_callback, async_multiline) {};
JQConsole.prototype.AbortPrompt = function() {};
JQConsole.prototype.Focus = function() {};
JQConsole.prototype.SetIndentWidth = function(width) {};
JQConsole.prototype.GetIndentWidth = function() {};
JQConsole.prototype.RegisterMatching = function(open, close, cls) {};
JQConsole.prototype.UnRegisterMatching = function(open, close) {};
JQConsole.prototype.Dump = function() {};
JQConsole.prototype.GetState = function() {};
JQConsole.prototype.Disable = function() {};
JQConsole.prototype.Enable = function() {};
JQConsole.prototype.IsDisabled = function() {};
JQConsole.prototype.MoveToStart = function(all_lines) {};
JQConsole.prototype.MoveToEnd = function(all_lines) {};
JQConsole.prototype.Clear = function() {};
JQConsole.prototype.SetKeyPressHandler = function(handler) {};
JQConsole.prototype.SetControlKeyHandler = function(handler) {};

/*---------------------- END Public Methods --------------------------- */
