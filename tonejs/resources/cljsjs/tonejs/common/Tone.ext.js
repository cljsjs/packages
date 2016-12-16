/*Basic stuff*/
var Tone = function() {};
Tone.Event = function() {};
Tone.Event.prototype.start = function() {}
Tone.Event.prototype.stop = function() {}
Tone.Event.prototype.cancel = function() {}
Tone.Event.prototype.dispose = function() {}

Tone.Loop = function() {};
Tone.Loop.prototype.start = function() {}
Tone.Loop.prototype.stop = function() {}
Tone.Loop.prototype.cancel = function() {}
Tone.Loop.prototype.dispose = function() {}

Tone.Part = function() {};
Tone.Part.prototype.start = function() {}
Tone.Part.prototype.stop = function() {}
Tone.Part.prototype.at = function() {}
Tone.Part.prototype.add = function() {}
Tone.Part.prototype.remove = function() {}
Tone.Part.prototype.removeAll = function() {}
Tone.Part.prototype.cancel = function() {}
Tone.Part.prototype.dispose = function() {}

Tone.Pattern = function() {};
Tone.Pattern.prototype.start = function() {}
Tone.Pattern.prototype.stop = function() {}
Tone.Pattern.prototype.cancel = function() {}
Tone.Pattern.prototype.dispose = function() {}

Tone.Sequence = function() {}
Tone.Sequence.prototype.at = function() {}
Tone.Sequence.prototype.add = function() {}
Tone.Sequence.prototype.remove = function() {}
Tone.Sequence.prototype.dispose = function() {}
Tone.Sequence.prototype.start = function() {}
Tone.Sequence.prototype.stop = function() {}
Tone.Sequence.prototype.removeAll = function() {}
Tone.Sequence.prototype.cancel = function() {}

/* Instruments */
Tone.AMSynth = function() {}
Tone.AMSynth.prototype.dispose = function() {}
Tone.AMSynth.prototype.triggerAttack = function() {}
Tone.AMSynth.prototype.triggerRelease = function() {}
Tone.AMSynth.prototype.setNote = function() {}
Tone.AMSynth.prototype.triggerAttackRelease = function() {}

Tone.DuoSynth = function() {}
Tone.DuoSynth.prototype.dispose = function() {}
Tone.DuoSynth.prototype.triggerAttack = function() {}
Tone.DuoSynth.prototype.triggerRelease = function() {}
Tone.DuoSynth.prototype.setNote = function() {}
Tone.DuoSynth.prototype.triggerAttackRelease = function() {}

Tone.FMSynth = function() {}
Tone.FMSynth.prototype.dispose = function() {}
Tone.FMSynth.prototype.triggerAttack = function() {}
Tone.FMSynth.prototype.triggerRelease = function() {}
Tone.FMSynth.prototype.setNote = function() {}
Tone.FMSynth.prototype.triggerAttackRelease = function() {}

Tone.Instrument = function() {}
Tone.Instrument.prototype.dispose = function() {}
Tone.Instrument.prototype.triggerAttackRelease = function() {}

Tone.MembraneSynth = function() {}
Tone.MembraneSynth.prototype.dispose = function() {}
Tone.MembraneSynth.prototype.triggerAttack = function() {}
Tone.MembraneSynth.prototype.triggerRelease = function() {}
Tone.MembraneSynth.prototype.setNote = function() {}
Tone.MembraneSynth.prototype.triggerAttackRelease = function() {}

Tone.MetalSynth = function() {}
Tone.MetalSynth.prototype.dispose = function() {}
Tone.MetalSynth.prototype.triggerAttack = function() {}
Tone.MetalSynth.prototype.triggerRelease = function() {}
Tone.MetalSynth.prototype.triggerAttackRelease = function() {}

Tone.MonoSynth = function() {}
Tone.MonoSynth.prototype.dispose = function() {}
Tone.MonoSynth.prototype.triggerAttack = function() {}
Tone.MonoSynth.prototype.triggerRelease = function() {}
Tone.MonoSynth.prototype.setNote = function() {}
Tone.MonoSynth.prototype.triggerAttackRelease = function() {}

Tone.Monophonic = function() {}
Tone.Monophonic.prototype.dispose = function() {}
Tone.Monophonic.prototype.triggerAttack = function() {}
Tone.Monophonic.prototype.triggerRelease = function() {}
Tone.Monophonic.prototype.setNote = function() {}
Tone.Monophonic.prototype.triggerAttackRelease = function() {}

Tone.NoiseSynth = function() {}
Tone.NoiseSynth.prototype.dispose = function() {}
Tone.NoiseSynth.prototype.triggerAttack = function() {}
Tone.NoiseSynth.prototype.triggerRelease = function() {}
Tone.NoiseSynth.prototype.triggerAttackRelease = function() {}

Tone.PluckSynth = function() {}
Tone.PluckSynth.prototype.dispose = function() {}
Tone.PluckSynth.prototype.triggerAttack = function() {}
Tone.PluckSynth.prototype.triggerAttackRelease = function() {}

Tone.PolySynth = function() {}
Tone.PolySynth.prototype.dispose = function() {}
Tone.PolySynth.prototype.triggerAttack = function() {}
Tone.PolySynth.prototype.triggerRelease = function() {}
Tone.PolySynth.prototype.get = function() {}
Tone.PolySynth.prototype.set = function() {}
Tone.PolySynth.prototype.releaseAll = function() {}
Tone.PolySynth.prototype.triggerAttackRelease = function() {}

Tone.Sampler = function() {}
Tone.Sampler.prototype.dispose = function() {}
Tone.Sampler.prototype.triggerAttack = function() {}
Tone.Sampler.prototype.triggerRelease = function() {}
Tone.Sampler.prototype.triggerAttackRelease = function() {}

Tone.Synth = function() {}
Tone.Synth.prototype.dispose = function() {}
Tone.Synth.prototype.triggerAttack = function() {}
Tone.Synth.prototype.triggerRelease = function() {}
Tone.Synth.prototype.setNote = function() {}
Tone.Synth.prototype.triggerAttackRelease = function() {}

/*Effects*/
Tone.AutoFilter = function() {}
Tone.AutoFilter.prototype.start = function() {}
Tone.AutoFilter.prototype.stop = function() {}
Tone.AutoFilter.prototype.sync = function() {}
Tone.AutoFilter.prototype.unsync = function() {}
Tone.AutoFilter.prototype.dispose = function() {}

Tone.AutoPanner = function() {}
Tone.AutoPanner.prototype.start = function() {}
Tone.AutoPanner.prototype.stop = function() {}
Tone.AutoPanner.prototype.sync = function() {}
Tone.AutoPanner.prototype.unsync = function() {}
Tone.AutoPanner.prototype.dispose = function() {}

Tone.AutoWah = function() {}
Tone.AutoWah.prototype.dispose = function() {}

Tone.BitCrusher = function() {}
Tone.BitCrusher.prototype.dispose = function() {}

Tone.Chebyshev = function() {}
Tone.Chebyshev.prototype.dispose = function() {}

Tone.Chorus = function() {}
Tone.Chorus.prototype.dispose = function() {}

Tone.Convolver = function() {}
Tone.Convolver.prototype.load = function() {}
Tone.Convolver.prototype.dispose = function() {}

Tone.Distortion = function() {}
Tone.Distortion.prototype.dispose = function() {}

Tone.Effect = function() {}
Tone.Effect.prototype.dispose = function() {}

Tone.FeedbackDelay = function() {}
Tone.FeedbackDelay.prototype.dispose = function() {}

Tone.FeedbackEffect = function() {}
Tone.FeedbackEffect.prototype.dispose = function() {}

Tone.Freeverb = function() {}
Tone.Freeverb.prototype.dispose = function() {}

Tone.JCReverb = function() {}
Tone.JCReverb.prototype.dispose = function() {}

Tone.MidiSideEffect = function() {}
Tone.MidiSideEffect.prototype.dispose = function() {}

Tone.Phaser = function() {}
Tone.Phaser.prototype.dispose = function() {}

Tone.PingPongDelay = function() {}
Tone.PingPongDelay.prototype.dispose = function() {}

Tone.FeedbackEffect = function() {}
Tone.FeedbackEffect.prototype.dispose = function() {}

Tone.StereoEffect = function() {}
Tone.StereoEffect.prototype.dispose = function() {}

Tone.StereoFeedbackEffect = function() {}
Tone.StereoFeedbackEffect.prototype.dispose = function() {}

Tone.StereoWidener = function() {}
Tone.StereoWidener.prototype.dispose = function() {}

Tone.StereoXFeedbackEffect = function() {}
Tone.StereoXFeedbackEffect.prototype.dispose = function() {}

Tone.Tremolo = function() {}
Tone.Tremolo.prototype.start = function() {}
Tone.Tremolo.prototype.stop = function() {}
Tone.Tremolo.prototype.sync = function() {}
Tone.Tremolo.prototype.unsync = function() {}
Tone.Tremolo.prototype.dispose = function() {}

Tone.Vibrato = function() {}
Tone.Vibrato.prototype.dispose = function() {}

/*Source*/
Tone.AMOscillator = function() {}
Tone.AMOscillator.prototype.start = function() {}
Tone.AMOscillator.prototype.stop = function() {}
Tone.AMOscillator.prototype.syncFrequency = function() {}
Tone.AMOscillator.prototype.sync = function() {}
Tone.AMOscillator.prototype.unsync = function() {}
Tone.AMOscillator.prototype.unsyncFrequency = function() {}
Tone.AMOscillator.prototype.dispose = function() {}

Tone.BufferSource = function() {}
Tone.BufferSource.prototype.start = function() {}
Tone.BufferSource.prototype.stop = function() {}
Tone.BufferSource.prototype.dispose = function() {}

Tone.ExternalInput = function() {}
Tone.ExternalInput.prototype.start = function() {}
Tone.ExternalInput.prototype.stop = function() {}
Tone.ExternalInput.prototype.sync = function() {}
Tone.ExternalInput.prototype.unsync = function() {}
Tone.ExternalInput.prototype.dispose = function() {}

Tone.FMOscillator = function() {}
Tone.FMOscillator.prototype.start = function() {}
Tone.FMOscillator.prototype.stop = function() {}
Tone.FMOscillator.prototype.syncFrequency = function() {}
Tone.FMOscillator.prototype.sync = function() {}
Tone.FMOscillator.prototype.unsync = function() {}
Tone.FMOscillator.prototype.unsyncFrequency = function() {}
Tone.FMOscillator.prototype.dispose = function() {}

Tone.FatOscillator = function() {}
Tone.FatOscillator.prototype.start = function() {}
Tone.FatOscillator.prototype.stop = function() {}
Tone.FatOscillator.prototype.syncFrequency = function() {}
Tone.FatOscillator.prototype.sync = function() {}
Tone.FatOscillator.prototype.unsync = function() {}
Tone.FatOscillator.prototype.unsyncFrequency = function() {}
Tone.FatOscillator.prototype.dispose = function() {}

Tone.GrainPlayer = function() {}
Tone.GrainPlayer.prototype.scrub = function() {}
Tone.GrainPlayer.prototype.dispose = function() {}

Tone.Microphone = function() {}
Tone.Microphone.prototype.open = function() {}
Tone.Microphone.prototype.close = function() {}
Tone.Microphone.prototype.start = function() {}
Tone.Microphone.prototype.stop = function() {}
Tone.Microphone.prototype.sync = function() {}
Tone.Microphone.prototype.unsync = function() {}
Tone.Microphone.prototype.dispose = function() {}

Tone.MultiPlayer = function() {}
Tone.MultiPlayer.prototype.start = function() {}
Tone.MultiPlayer.prototype.startLoop = function() {}
Tone.MultiPlayer.prototype.stop = function() {}
Tone.MultiPlayer.prototype.stopAll = function() {}
Tone.MultiPlayer.prototype.add = function() {}
Tone.MultiPlayer.prototype.dispose = function() {}

Tone.Noise = function() {}
Tone.Noise.prototype.set = function() {}
Tone.Noise.prototype.syncFrequency = function() {}
Tone.Noise.prototype.unsyncFrequency = function() {}
Tone.Noise.prototype.start = function() {}
Tone.Noise.prototype.stop = function() {}
Tone.Noise.prototype.sync = function() {}
Tone.Noise.prototype.unsync = function() {}
Tone.Noise.prototype.dispose = function() {}
Tone.Noise.prototype.dispose = function() {}

Tone.OmniOscillator = function() {}
Tone.OmniOscillator.prototype.syncFrequency = function() {}
Tone.OmniOscillator.prototype.unsyncFrequency = function() {}
Tone.OmniOscillator.prototype.start = function() {}
Tone.OmniOscillator.prototype.stop = function() {}
Tone.OmniOscillator.prototype.sync = function() {}
Tone.OmniOscillator.prototype.unsync = function() {}
Tone.OmniOscillator.prototype.dispose = function() {}

Tone.Oscillator = function() {}
Tone.Oscillator.prototype.syncFrequency = function() {}
Tone.Oscillator.prototype.unsyncFrequency = function() {}
Tone.Oscillator.prototype.start = function() {}
Tone.Oscillator.prototype.stop = function() {}
Tone.Oscillator.prototype.sync = function() {}
Tone.Oscillator.prototype.unsync = function() {}
Tone.Oscillator.prototype.dispose = function() {}

Tone.PWMOscillator = function() {}
Tone.PWMOscillator.prototype.syncFrequency = function() {}
Tone.PWMOscillator.prototype.unsyncFrequency = function() {}
Tone.PWMOscillator.prototype.start = function() {}
Tone.PWMOscillator.prototype.stop = function() {}
Tone.PWMOscillator.prototype.sync = function() {}
Tone.PWMOscillator.prototype.unsync = function() {}
Tone.PWMOscillator.prototype.dispose = function() {}

Tone.Player = function() {}
Tone.Player.prototype.load = function() {}
Tone.Player.prototype.start = function() {}
Tone.Player.prototype.seek = function() {}
Tone.Player.prototype.setLoopPoints = function() {}
Tone.Player.prototype.stop = function() {}
Tone.Player.prototype.sync = function() {}
Tone.Player.prototype.unsync = function() {}
Tone.Player.prototype.dispose = function() {}

Tone.PulseOscillator = function() {}
Tone.PulseOscillator.prototype.syncFrequency = function() {}
Tone.PulseOscillator.prototype.unsyncFrequency = function() {}
Tone.PulseOscillator.prototype.start = function() {}
Tone.PulseOscillator.prototype.stop = function() {}
Tone.PulseOscillator.prototype.sync = function() {}
Tone.PulseOscillator.prototype.unsync = function() {}
Tone.PulseOscillator.prototype.dispose = function() {}

Tone.Source = function() {}
Tone.Source.prototype.start = function() {}
Tone.Source.prototype.stop = function() {}
Tone.Source.prototype.sync = function() {}
Tone.Source.prototype.unsync = function() {}
Tone.Source.prototype.dispose = function() {}

/*Core*/
Tone.Buffer = function() {}
Tone.Buffer.prototype.set = function() {}
Tone.Buffer.prototype.get = function() {}
Tone.Buffer.prototype.load = function() {}
Tone.Buffer.prototype.dispose = function() {}
Tone.Buffer.prototype.fromArray = function() {}
Tone.Buffer.prototype.toArray = function() {}
Tone.Buffer.prototype.slice = function() {}
Tone.Buffer.prototype.supportsType = function() {}

Tone.Buffers = function() {}
Tone.Buffers.prototype.has = function() {}
Tone.Buffers.prototype.get = function() {}
Tone.Buffers.prototype.add = function() {}
Tone.Buffers.prototype.dispose = function() {}

Tone.Clock = function() {}
Tone.Clock.prototype.start = function() {}
Tone.Clock.prototype.stop = function() {}
Tone.Clock.prototype.pause = function() {}
Tone.Clock.prototype.getStateAtTime = function() {}
Tone.Clock.prototype.on = function() {}
Tone.Clock.prototype.off = function() {}
Tone.Clock.prototype.emit = function() {}
Tone.Clock.prototype.dispose = function() {}

Tone.Delay = function() {}
Tone.Delay.prototype.dispose = function() {}

Tone.Emitter = function() {}
Tone.Emitter.prototype.on = function() {}
Tone.Emitter.prototype.off = function() {}
Tone.Emitter.prototype.emit = function() {}
Tone.Emitter.prototype.mixin = function() {}
Tone.Emitter.prototype.dispose = function() {}

Tone.Gain = function() {}
Tone.Gain.prototype.dispose = function() {}

Tone.IntervalTimeline = function() {}
Tone.IntervalTimeline.prototype.addEvent = function() {}
Tone.IntervalTimeline.prototype.removeEvent = function() {}
Tone.IntervalTimeline.prototype.cancel = function() {}
Tone.IntervalTimeline.prototype.getEvent = function() {}
Tone.IntervalTimeline.prototype.forEach = function() {}
Tone.IntervalTimeline.prototype.forEachAtTime = function() {}
Tone.IntervalTimeline.prototype.forEachAfter = function() {}
Tone.IntervalTimeline.prototype.dispose = function() {}

Tone.Listener = function() {}
Tone.Listener.prototype.setPosition = function() {}
Tone.Listener.prototype.setOrientation = function() {}
Tone.Listener.prototype.dispose = function() {}

Tone.Master = function() {}
Tone.Master.prototype.chain = function() {}
Tone.Master.prototype.dispose = function() {}

Tone.Param = function() {}
Tone.Param.prototype.setValueAtTime = function() {}
Tone.Param.prototype.setRampPoint = function() {}
Tone.Param.prototype.linearRampToValueAtTime = function() {}
Tone.Param.prototype.exponentialRampToValueAtTime = function() {}
Tone.Param.prototype.exponentialRampToValue = function() {}
Tone.Param.prototype.linearRampToValue = function() {}
Tone.Param.prototype.setTargetAtTime = function() {}
Tone.Param.prototype.setValueCurveAtTime = function() {}
Tone.Param.prototype.cancelScheduledValues = function() {}
Tone.Param.prototype.rampTo = function() {}
Tone.Param.prototype.dispose = function() {}

Tone.Timeline = function() {}
Tone.Timeline.prototype.addEvent = function() {}
Tone.Timeline.prototype.removeEvent = function() {}
Tone.Timeline.prototype.getEvent = function() {}
Tone.Timeline.prototype.removeEvent = function() {}
Tone.Timeline.prototype.getEventAfter = function() {}
Tone.Timeline.prototype.getEventBefore = function() {}
Tone.Timeline.prototype.cancel = function() {}
Tone.Timeline.prototype.cancelBefore = function() {}
Tone.Timeline.prototype.forEach = function() {}
Tone.Timeline.prototype.forEachBefore = function() {}
Tone.Timeline.prototype.forEachAfter = function() {}
Tone.Timeline.prototype.forEachFrom = function() {}
Tone.Timeline.prototype.forEachAtTime = function() {}
Tone.Timeline.prototype.dispose = function() {}

Tone.TimelineState = function() {}
Tone.TimelineState.prototype.getStateAtTime = function() {}
Tone.TimelineState.prototype.setStateAtTime = function() {}
Tone.TimelineState.prototype.addEvent = function() {}
Tone.TimelineState.prototype.removeEvent = function() {}
Tone.TimelineState.prototype.getEvent = function() {}
Tone.TimelineState.prototype.getEventAfter = function() {}
Tone.TimelineState.prototype.getEventBefore = function() {}
Tone.TimelineState.prototype.cancel = function() {}
Tone.TimelineState.prototype.cancelBefore = function() {}
Tone.TimelineState.prototype.forEach = function() {}
Tone.TimelineState.prototype.forEachBefore = function() {}
Tone.TimelineState.prototype.forEachAfter = function() {}
Tone.TimelineState.prototype.forEachFrom = function() {}
Tone.TimelineState.prototype.forEachAtTime = function() {}
Tone.TimelineState.prototype.dispose = function() {}

Tone.Tone = function() {}
Tone.Tone.send = function() {}
Tone.Tone.receive = function() {}
Tone.Tone.createInsOuts = function() {}
Tone.Tone.toMaster = function() {}
Tone.Tone.set = function() {}
Tone.Tone.get = function() {}
Tone.Tone.toString = function() {}
Tone.Tone.noGC = function() {}
Tone.Tone.connect = function() {}
Tone.Tone.disconnect = function() {}
Tone.Tone.connectSeries = function() {}
Tone.Tone.chain = function() {}
Tone.Tone.fan = function() {}
Tone.Tone.defaultArg = function() {}
Tone.Tone.optionsObject = function() {}
Tone.Tone.isUndef = function() {}
Tone.Tone.isFunction = function() {}
Tone.Tone.isNumber = function() {}
Tone.Tone.isObject = function() {}
Tone.Tone.isBoolean = function() {}
Tone.Tone.isArray = function() {}
Tone.Tone.isString = function() {}
Tone.Tone.noOp = function() {}
Tone.Tone.equalPowerScale = function() {}
Tone.Tone.dbToGain = function() {}
Tone.Tone.gainToDb = function() {}
Tone.Tone.intervalToFrequencyRatio = function() {}
Tone.Tone.now = function() {}
Tone.Tone.extend = function() {}
Tone.Tone.setContext = function() {}
Tone.Tone.toSeconds = function() {}
Tone.Tone.toFrequency = function() {}
Tone.Tone.toTicks = function() {}
Tone.Tone.dispose = function() {}

Tone.Transport = function() {}
Tone.Transport.prototype.schedule = function() {}
Tone.Transport.prototype.scheduleRepeat = function() {}
Tone.Transport.prototype.scheduleOnce = function() {}
Tone.Transport.prototype.clear = function() {}
Tone.Transport.prototype.cancel = function() {}
Tone.Transport.prototype._bindClockEvents = function() {}
Tone.Transport.prototype.start = function() {}
Tone.Transport.prototype.stop = function() {}
Tone.Transport.prototype.pause = function() {}
Tone.Transport.prototype.setLoopPoints = function() {}
Tone.Transport.prototype.nextSubdivision = function() {}
Tone.Transport.prototype.syncSignal = function() {}
Tone.Transport.prototype.unsyncSignal = function() {}
Tone.Transport.prototype.on = function() {}
Tone.Transport.prototype.off = function() {}
Tone.Transport.prototype.emit = function() {}

/*Types*/
Tone.Frequency = function() {}
Tone.Frequency.prototype.transpose = function() {}
Tone.Frequency.prototype.harmonize = function() {}
Tone.Frequency.prototype.toMidi = function() {}
Tone.Frequency.prototype.toNote = function() {}
Tone.Frequency.prototype.toSeconds = function() {}
Tone.Frequency.prototype.toFrequency = function() {}
Tone.Frequency.prototype.toTicks = function() {}
Tone.Frequency.prototype.midiToFrequency = function() {}
Tone.Frequency.prototype.frequencyToMidi = function() {}
Tone.Frequency.prototype.set = function() {}
Tone.Frequency.prototype.copy = function() {}
Tone.Frequency.prototype.clone = function() {}
Tone.Frequency.prototype.add = function() {}
Tone.Frequency.prototype.sub = function() {}
Tone.Frequency.prototype.mult = function() {}
Tone.Frequency.prototype.div = function() {}
Tone.Frequency.prototype.eval = function() {}
Tone.Frequency.prototype.dispose = function() {}

Tone.Time = function() {}
Tone.Time.prototype.quantize = function() {}
Tone.Time.prototype.addNow = function() {}
Tone.Time.prototype.copy = function() {}
Tone.Time.prototype.toNotation = function() {}
Tone.Time.prototype.toBarsBeatsSixteenths = function() {}
Tone.Time.prototype.toTicks = function() {}
Tone.Time.prototype.toSamples = function() {}
Tone.Time.prototype.toFrequency = function() {}
Tone.Time.prototype.toSeconds = function() {}
Tone.Time.prototype.toMilliseconds = function() {}
Tone.Time.prototype.eval = function() {}
Tone.Time.prototype.set = function() {}
Tone.Time.prototype.clone = function() {}
Tone.Time.prototype.add = function() {}
Tone.Time.prototype.sub = function() {}
Tone.Time.prototype.mult = function() {}
Tone.Time.prototype.div = function() {}
Tone.Time.prototype.dispose = function() {}

Tone.TimeBase = function() {}
Tone.TimeBase.prototype.set = function() {}
Tone.TimeBase.prototype.clone = function() {}
Tone.TimeBase.prototype.copy = function() {}
Tone.TimeBase.prototype.add = function() {}
Tone.TimeBase.prototype.sub = function() {}
Tone.TimeBase.prototype.mult = function() {}
Tone.TimeBase.prototype.div = function() {}
Tone.TimeBase.prototype.eval = function() {}
Tone.TimeBase.prototype.dispose = function() {}

Tone.TransportTime = function() {}
Tone.TransportTime.prototype.eval = function() {}
Tone.TransportTime.prototype.toTicks = function() {}
Tone.TransportTime.prototype.toSeconds = function() {}
Tone.TransportTime.prototype.toFrequency = function() {}
Tone.TransportTime.prototype.quantize = function() {}
Tone.TransportTime.prototype.addNow = function() {}
Tone.TransportTime.prototype.copy = function() {}
Tone.TransportTime.prototype.toNotation = function() {}
Tone.TransportTime.prototype.toBarsBeatsSixteenths = function() {}
Tone.TransportTime.prototype.toSamples = function() {}
Tone.TransportTime.prototype.toMilliseconds = function() {}
Tone.TransportTime.prototype.set = function() {}
Tone.TransportTime.prototype.clone = function() {}
Tone.TransportTime.prototype.add = function() {}
Tone.TransportTime.prototype.sub = function() {}
Tone.TransportTime.prototype.mult = function() {}
Tone.TransportTime.prototype.toSeconds = function() {}
Tone.TransportTime.prototype.div = function() {}
Tone.TransportTime.prototype.dispose = function() {}

Tone.AmplitudeEnvelope = function() {}
Tone.Analyser = function() {}
Tone.Analyser.prototype.analyse = function() {}
Tone.Analyser.prototype.dispose = function() {}

Tone.Compressor = function() {}
Tone.Compressor.prototype.dispose = function() {}

Tone.CrossFade = function() {}
Tone.CrossFade.prototype.dispose = function() {}

Tone.EQ3 = function() {}
Tone.EQ3.prototype.dispose = function() {}

Tone.Envelope = function() {}
Tone.Envelope.prototype.triggerAttack = function() {}
Tone.Envelope.prototype.triggerRelease = function() {}
Tone.Envelope.prototype.getValueAtTime = function() {}
Tone.Envelope.prototype.triggerAttackRelease = function() {}
Tone.Envelope.prototype.cancel = function() {}
Tone.Envelope.prototype.dispose = function() {}

Tone.FeedbackCombFilter = function() {}
Tone.FeedbackCombFilter.prototype.dispose = function() {}

Tone.Filter = function() {}
Tone.Filter.prototype.dispose = function() {}

Tone.Follower = function() {}
Tone.Follower.prototype.connect = function() {}
Tone.Follower.prototype.dispose = function() {}

Tone.FrequencyEnvelope = function() {}
Tone.FrequencyEnvelope.prototype.dispose = function() {}
Tone.FrequencyEnvelope.prototype.triggerAttack = function() {}
Tone.FrequencyEnvelope.prototype.triggerRelease = function() {}
Tone.FrequencyEnvelope.prototype.getValueAtTime = function() {}
Tone.FrequencyEnvelope.prototype.triggerAttackRelease = function() {}
Tone.FrequencyEnvelope.prototype.cancel = function() {}

Tone.Gate = function() {}
Tone.Gate.prototype.dispose = function() {}

Tone.LFO = function() {}
Tone.LFO.prototype.start = function() {}
Tone.LFO.prototype.stop = function() {}
Tone.LFO.prototype.sync = function() {}
Tone.LFO.prototype.unsync = function() {}
Tone.LFO.prototype.dispose = function() {}
Tone.LFO.prototype.syncFrequency = function() {}
Tone.LFO.prototype.unsyncFrequency = function() {}

Tone.Limiter = function() {}
Tone.Limiter.prototype.dispose = function() {}

Tone.LowpassCombFilter = function() {}
Tone.LowpassCombFilter.prototype.dispose = function() {}

Tone.Merge = function() {}
Tone.Merge.prototype.dispose = function() {}

Tone.Meter = function() {}
Tone.Meter.prototype.dispose = function() {}

Tone.MidSideCompressor = function() {}
Tone.MidSideCompressor.prototype.dispose = function() {}

Tone.MidSideMerge = function() {}
Tone.MidSideMerge.prototype.dispose = function() {}

Tone.MidSideSplit = function() {}
Tone.MidSideSplit.prototype.dispose = function() {}

Tone.Mono = function() {}
Tone.Mono.prototype.dispose = function() {}

Tone.MultibandCompressor = function() {}
Tone.MultibandCompressor.prototype.dispose = function() {}

Tone.MultibandSplit = function() {}
Tone.MultibandSplit.prototype.dispose = function() {}

Tone.PanVol = function() {}
Tone.PanVol.prototype.dispose = function() {}

Tone.Panner = function() {}
Tone.Panner.prototype.dispose = function() {}

Tone.Panner3D = function() {}
Tone.Panner3D.prototype.setPosition = function() {}
Tone.Panner3D.prototype.setOrientation = function() {}
Tone.Panner3D.prototype.dispose = function() {}

Tone.ScaledEnvelope = function() {}
Tone.ScaledEnvelope.prototype.triggerAttack = function() {}
Tone.ScaledEnvelope.prototype.triggerRelease = function() {}
Tone.ScaledEnvelope.prototype.getValueAtTime = function() {}
Tone.ScaledEnvelope.prototype.triggerAttackRelease = function() {}
Tone.ScaledEnvelope.prototype.cancel = function() {}
Tone.ScaledEnvelope.prototype.dispose = function() {}

Tone.Split = function() {}
Tone.Split.prototype.dispose = function() {}

Tone.Volume = function() {}
Tone.Volume.prototype.dispose = function() {}

/* Signal */
Tone.SignalBase = function() {}
Tone.SignalBase.prototype.dispose = function() {}

Tone.Signal = function() {}
Tone.Signal.prototype.setValueAtTime = function() {}
Tone.Signal.prototype.setRampPoint = function() {}
Tone.Signal.prototype.linearRampToValueAtTime = function() {}
Tone.Signal.prototype.exponentialRampToValueAtTime = function() {}
Tone.Signal.prototype.exponentialRampToValue = function() {}
Tone.Signal.prototype.linearRampToValue = function() {}
Tone.Signal.prototype.setTargetAtTime = function() {}
Tone.Signal.prototype.setValueCurveAtTime = function() {}
Tone.Signal.prototype.cancelScheduledValues = function() {}
Tone.Signal.prototype.rampTo = function() {}
Tone.Signal.prototype.dispose = function() {}

Tone.AudioToGain = function() {}
Tone.AudioToGain.prototype.dispose = function() {}

Tone.AudioToGain = function() {}
Tone.AudioToGain.prototype.dispose = function() {}

Tone.EqualPowerGain = function() {}
Tone.EqualPowerGain.prototype.dispose = function() {}

Tone.EqualPowerGain = function() {}
Tone.EqualPowerGain.prototype.dispose = function() {}

Tone.Expr = function() {}
Tone.Expr.prototype.dispose = function() {}

Tone.GainToAudio = function() {}
Tone.GainToAudio.prototype.dispose = function() {}

Tone.GreaterThan = function() {}
Tone.GreaterThan.prototype.setValueAtTime = function() {}
Tone.GreaterThan.prototype.setRampPoint = function() {}
Tone.GreaterThan.prototype.linearRampToValueAtTime = function() {}
Tone.GreaterThan.prototype.exponentialRampToValueAtTime = function() {}
Tone.GreaterThan.prototype.exponentialRampToValue = function() {}
Tone.GreaterThan.prototype.linearRampToValue = function() {}
Tone.GreaterThan.prototype.setTargetAtTime = function() {}
Tone.GreaterThan.prototype.setValueCurveAtTime = function() {}
Tone.GreaterThan.prototype.cancelScheduledValues = function() {}
Tone.GreaterThan.prototype.rampTo = function() {}
Tone.GreaterThan.prototype.dispose = function() {}

Tone.GreaterThanZero = function() {}
Tone.GreaterThanZero.prototype.dispose = function() {}

Tone.Modulo = function() {}
Tone.Modulo.prototype.dispose = function() {}

Tone.Multiply = function() {}
Tone.Multiply.prototype.setValueAtTime = function() {}
Tone.Multiply.prototype.setRampPoint = function() {}
Tone.Multiply.prototype.linearRampToValueAtTime = function() {}
Tone.Multiply.prototype.exponentialRampToValueAtTime = function() {}
Tone.Multiply.prototype.exponentialRampToValue = function() {}
Tone.Multiply.prototype.linearRampToValueAtTime = function() {}
Tone.Multiply.prototype.setTargetAtTime = function() {}
Tone.Multiply.prototype.setValueCurveAtTime = function() {}
Tone.Multiply.prototype.cancelScheduledValues = function() {}
Tone.Multiply.prototype.rampTo = function() {}
Tone.Multiply.prototype.dispose = function() {}

Tone.Negate = function() {}
Tone.Negate.prototype.dispose = function() {}

Tone.Normalize = function() {}
Tone.Normalize.prototype.dispose = function() {}

Tone.Pow = function() {}
Tone.Pow.prototype.dispose = function() {}

Tone.Scale = function() {}
Tone.Scale.prototype.dispose = function() {}

Tone.ScaleExp = function() {}
Tone.ScaleExp.prototype.dispose = function() {}

Tone.Signal = function() {}
Tone.Signal.prototype.connect = function() {}
Tone.Signal.prototype.dispose = function() {}
Tone.Signal.prototype.setValueAtTime = function() {}
Tone.Signal.prototype.setRampPoint = function() {}
Tone.Signal.prototype.linearRampToValueAtTime = function() {}
Tone.Signal.prototype.exponentialRampToValueAtTime = function() {}
Tone.Signal.prototype.exponentialRampToValue = function() {}
Tone.Signal.prototype.linearRampToValue = function() {}
Tone.Signal.prototype.setTargetAtTime = function() {}
Tone.Signal.prototype.setValueCurveAtTime = function() {}
Tone.Signal.prototype.cancelScheduledValues = function() {}
Tone.Signal.prototype.rampTo = function() {}

Tone.SignalBase = function() {}
Tone.SignalBase.prototype.connect = function() {}

Tone.Subtract = function() {}
Tone.Subtract.prototype.dispose = function() {}
Tone.Subtract.prototype.setValueAtTime = function() {}
Tone.Subtract.prototype.setRampPoint = function() {}
Tone.Subtract.prototype.linearRampToValueAtTime = function() {}
Tone.Subtract.prototype.exponentialRampToValueAtTime = function() {}
Tone.Subtract.prototype.exponentialRampToValue = function() {}
Tone.Subtract.prototype.linearRampToValue = function() {}
Tone.Subtract.prototype.setTargetAtTime = function() {}
Tone.Subtract.prototype.setValueCurveAtTime = function() {}
Tone.Subtract.prototype.cancelScheduledValues = function() {}
Tone.Subtract.prototype.rampTo = function() {}

Tone.TimelineSignal = function() {}
Tone.TimelineSignal.prototype.dispose = function() {}
Tone.TimelineSignal.prototype.setValueAtTime = function() {}
Tone.TimelineSignal.prototype.setRampPoint = function() {}
Tone.TimelineSignal.prototype.linearRampToValueAtTime = function() {}
Tone.TimelineSignal.prototype.exponentialRampToValueAtTime = function() {}
Tone.TimelineSignal.prototype.exponentialRampToValue = function() {}
Tone.TimelineSignal.prototype.linearRampToValue = function() {}
Tone.TimelineSignal.prototype.setTargetAtTime = function() {}
Tone.TimelineSignal.prototype.setValueCurveAtTime = function() {}
Tone.TimelineSignal.prototype.cancelScheduledValues = function() {}
Tone.TimelineSignal.prototype.rampTo = function() {}

Tone.WaveShaper = function() {}
Tone.WaveShaper.prototype.setMap = function() {}
Tone.WaveShaper.prototype.dispose = function() {}

Tone.Zero = function() {}
Tone.Zero.prototype.dispose = function() {}

Tone.CtrlInterpolate = function() {}
Tone.CtrlInterpolate.prototype.dispose = function() {}

Tone.CtrlMarkov = function() {}
Tone.CtrlMarkov.prototype.next = function() {}
Tone.CtrlMarkov.prototype.dispose = function() {}

Tone.CtrlPattern = function() {}
Tone.CtrlPattern.prototype.next = function() {}
Tone.CtrlPattern.prototype.dispose = function() {}

Tone.CtrlRandom = function() {};
