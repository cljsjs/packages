/**@constructor*/
function b2AABB() {
this.lowerBound = {};
this.upperBound = {};
}
b2AABB.prototype.GetCenter = function() {
};
// todo use just the pointer and offsets to get this data directly from the heap
/**@constructor*/
function b2Manifold(ptr) {
this.ptr = ptr;
}
b2Manifold.prototype.GetPointCount = function() {
};
/**@constructor*/
function b2WorldManifold(ptr) {
this.buffer = {};
this.ptr = ptr;
}
b2WorldManifold.prototype.GetPoint = function(i) {
};
var FLT_EPSILON = 1.19209290E-07;
function b2Max(a ,b) {
}
function b2Min(a, b) {
}
function b2Clamp(a, low, high) {
}
/** @constructor */
function b2Vec2(x, y) {
this.x = x;
this.y = y;
}
// static functions on b2Vec2
b2Vec2.Add = function(out, a, b) {
};
b2Vec2.CrossScalar = function(output, input, scalar) {
};
b2Vec2.Cross = function(a, b) {
};
b2Vec2.MulScalar = function(out, input, scalar) {
};
b2Vec2.Mul = function(out, T, v) {
};
b2Vec2.Normalize = function(out, input) {
};
b2Vec2.Sub = function(out, input, subtract) {
};
b2Vec2.prototype.Clone = function() {
};
b2Vec2.prototype.Set = function(x, y) {
this.x = x;
this.y = y;
};
b2Vec2.prototype.Length = function() {
};
b2Vec2.prototype.LengthSquared = function() {
};
/** @constructor */
function b2Rot(radians) {
this.s = 1;
this.c = 1;
}
b2Rot.prototype.Set = function(radians) {
};
b2Rot.prototype.SetIdentity = function() {
this.s = 0;
this.c = 1;
};
b2Rot.prototype.GetXAxis = function() {
};
/** @constructor */
function b2Transform(position, rotation) {
this.p = position;
this.q = rotation;
}
b2Transform.prototype.FromFloat64Array = function(arr) {
};
b2Transform.prototype.SetIdentity = function() {
this.p.Set(0, 0);
this.q.SetIdentity();
};
// b2Body Globals
// memory offsets
/**@constructor*/
function b2Body(ptr) {
this.buffer = {};
this.ptr = ptr;
this.fixtures = [];
}
b2Body.prototype.ApplyAngularImpulse = function(impulse, wake) {
};
b2Body.prototype.ApplyLinearImpulse = function(impulse, point, wake) {
};
b2Body.prototype.ApplyForce = function(force, point, wake) {
};
b2Body.prototype.ApplyForceToCenter = function(force, wake) {
};
b2Body.prototype.ApplyTorque = function(force, wake) {
};
b2Body.prototype.CreateFixtureFromDef = function(fixtureDef) {
};
b2Body.prototype.CreateFixtureFromShape = function(shape, density) {
};
b2Body.prototype.DestroyFixture = function(fixture) {
};
b2Body.prototype.GetAngle = function() {
};
b2Body.prototype.GetAngularVelocity = function() {
};
b2Body.prototype.GetInertia = function() {
};
b2Body.prototype.GetMass = function() {
};
b2Body.prototype.GetLinearVelocity = function() {
};
b2Body.prototype.GetLocalPoint = function(vec) {
};
b2Body.prototype.GetLocalVector = function(vec) {
};
b2Body.prototype.GetPosition = function() {
};
b2Body.prototype.GetTransform = function() {
};
b2Body.prototype.GetType = function() {
};
b2Body.prototype.GetUserData = function() {
};
b2Body.prototype.GetWorldCenter = function() {
};
b2Body.prototype.GetWorldPoint = function(vec) {
};
b2Body.prototype.GetWorldVector = function(vec) {
};
b2Body.prototype.SetAngularVelocity = function(angle) {
};
b2Body.prototype.SetAwake = function(flag) {
};
b2Body.prototype.SetFixedRotation = function(flag) {
};
b2Body.prototype.SetLinearVelocity = function(v) {
};
b2Body.prototype.SetMassData = function(massData) {
};
b2Body.prototype.SetTransform = function(v, angle) {
};
b2Body.prototype.SetType = function(type) {
};
// General body globals
var b2_staticBody = 0;
var b2_kinematicBody = 1;
var b2_dynamicBody = 2;
/** @constructor */
function b2BodyDef() {
this.active = true;
this.allowSleep = true;
this.angle = 0;
this.angularVelocity = 0;
this.angularDamping = 0;
this.awake = true;
this.bullet = false;
this.fixedRotation = false;
this.gravityScale = 1.0;
this.linearDamping = 0;
this.linearVelocity = {};
this.position = {};
this.type = b2_staticBody;
this.userData = {};
}
/**@constructor*/
function b2Filter() {
this.categoryBits = 0x0001;
this.groupIndex = 0;
this.maskBits = 0xFFFF;
}
// fixture globals
/**@constructor*/
function b2Fixture() {
this.body = {};
this.buffer = {};
this.ptr = {};
this.shape = {};
}
b2Fixture.prototype._SetPtr = function(ptr) {
this.ptr = ptr;
this.buffer = {};
};
b2Fixture.prototype.FromFixtureDef = function(fixtureDef) {
this.density = fixtureDef.density;
this.friction = fixtureDef.friction;
this.isSensor = fixtureDef.isSensor;
this.restitution = fixtureDef.restitution;
this.shape = fixtureDef.shape;
this.userData = fixtureDef.userData;
this.vertices = [];
};
b2Fixture.prototype.GetUserData = function() {
};
b2Fixture.prototype.SetSensor = function(flag) {
};
b2Fixture.prototype.TestPoint = function(p) {
};
/**@constructor*/
function b2FixtureDef() {
this.density = 0.0;
this.friction = 0.2;
this.isSensor = false;
this.restitution = 0.0;
this.shape = {};
this.userData = {};
this.filter = {};
}
// global call back functions
b2World.BeginContactBody = function(contactPtr) {
};
b2World.EndContactBody = function(contactPtr) {
};
b2World.PreSolve = function(contactPtr, oldManifoldPtr) {
};
b2World.PostSolve = function(contactPtr, impulsePtr) {
};
b2World.QueryAABB = function(fixturePtr) {
};
b2World.RayCast = function(fixturePtr, pointX, pointY, normalX, normalY, fraction) {
};
// Emscripten exports
var _transBuf = {};
var _vec2Buf = {};
// Todo move the buffers to native access
/** @constructor */
function b2World(gravity) {
this.bodies = [];
this.bodiesLookup = {};
this.fixturesLookup = {};
this.joints = [];
this.listener = {};
this.particleSystems = [];
this.ptr = {};
this.queryAABBCallback = {};
this.rayCastCallback = {};
this.buffer = {};
}
b2World._Push = function(item, list) {
};
b2World._RemoveItem = function(item, list) {
};
b2World.prototype.CreateBody = function(bodyDef) {
};
b2World.prototype.CreateJoint = function(jointDef) {
};
b2World.prototype.CreateParticleSystem = function(psd) {
};
b2World.prototype.DestroyBody = function(body) {
};
b2World.prototype.DestroyJoint = function(joint) {
};
b2World.prototype.DestroyParticleSystem = function(particleSystem) {
};
b2World.prototype.QueryAABB = function(callback, aabb) {
callback.ReportFixture = function() {};
this.queryAABBCallback = callback;
};
b2World.prototype.RayCast = function(callback, point1, point2) {
callback.ReportFixture = function() {};
this.rayCastCallback = callback;
};
b2World.prototype.SetContactListener = function(listener) {
listener.BeginContactBody = function() {};
listener.EndContactBody = function() {};
listener.PreSolve = function() {};
listener.PostSolve = function() {};
this.listener = listener;
};
b2World.prototype.SetGravity = function(gravity) {
};
b2World.prototype.Step = function(steps, vIterations, pIterations) {
};
// in memory a contact impulse looks like
// float normalImpulse[0]
// float normalImpulse[1]
// float tangentImpulse[0]
// float tangentImpulse[1]
// int count
// TODO update with offsets table
/** @constructor */
function b2ContactImpulse(ptr) {
this.ptr = ptr;
this.buffer = {};
}
b2ContactImpulse.prototype.GetNormalImpulse = function(i) {
};
b2ContactImpulse.prototype.GetTangentImpulse = function(i) {
};
b2ContactImpulse.prototype.GetCount = function(i) {
};
/// Water particle.
var b2_waterParticle = 0;
/// Removed after next simulation step.
var b2_zombieParticle = 1 << 1;
/// Zero velocity.
var b2_wallParticle = 1 << 2;
/// With restitution from stretching.
var b2_springParticle = 1 << 3;
/// With restitution from deformation.
var b2_elasticParticle = 1 << 4;
/// With viscosity.
var b2_viscousParticle = 1 << 5;
/// Without isotropic pressure.
var b2_powderParticle = 1 << 6;
/// With surface tension.
var b2_tensileParticle = 1 << 7;
/// Mix color between contacting particles.
var b2_colorMixingParticle = 1 << 8;
/// Call b2DestructionListener on destruction.
var b2_destructionListenerParticle = 1 << 9;
/// Prevents other particles from leaking.
var b2_barrierParticle = 1 << 10;
/// Less compressibility.
var b2_staticPressureParticle = 1 << 11;
/// Makes pairs or triads with other particles.
var b2_reactiveParticle = 1 << 12;
/// With high repulsive force.
var b2_repulsiveParticle = 1 << 13;
/// Call b2ContactListener when this particle is about to interact with
/// a rigid body or stops interacting with a rigid body.
/// This results in an expensive operation compared to using
/// b2_fixtureContactFilterParticle to detect collisions between
/// particles.
var b2_fixtureContactListenerParticle = 1 << 14;
/// Call b2ContactListener when this particle is about to interact with
/// another particle or stops interacting with another particle.
/// This results in an expensive operation compared to using
/// b2_particleContactFilterParticle to detect collisions between
/// particles.
var b2_particleContactListenerParticle = 1 << 15;
/// Call b2ContactFilter when this particle interacts with rigid bodies.
var b2_fixtureContactFilterParticle = 1 << 16;
/// Call b2ContactFilter when this particle interacts with other
/// particles.
var b2_particleContactFilterParticle = 1 << 17;
/** @constructor */
function b2ParticleColor(r, g, b, a) {
this.r = r;
this.g = g;
this.b = b;
this.a = a;
}
b2ParticleColor.prototype.Set = function(r, g, b, a) {
this.r = r;
this.g = g;
this.b = b;
this.a = a;
};
/**@constructor*/
function b2ParticleDef() {
this.color = {};
this.flags = 0;
this.group = 0;
this.lifetime = 0.0;
this.position = {};
this.userData = 0;
this.velocity = {};
}
/// Prevents overlapping or leaking.
var b2_solidParticleGroup = 1 << 0;
/// Keeps its shape.
var b2_rigidParticleGroup = 1 << 1;
/// Won't be destroyed if it gets empty.
var b2_particleGroupCanBeEmpty = 1 << 2;
/// Will be destroyed on next simulation step.
var b2_particleGroupWillBeDestroyed = 1 << 3;
/// Updates depth data on next simulation step.
var b2_particleGroupNeedsUpdateDepth = 1 << 4;
/** @constructor */
function b2ParticleGroup(ptr) {
this.buffer = {};
this.ptr = ptr;
}
b2ParticleGroup.prototype.ApplyForce = function(force) {
};
b2ParticleGroup.prototype.ApplyLinearImpulse = function(impulse) {
};
b2ParticleGroup.prototype.DestroyParticles = function(flag) {
};
b2ParticleGroup.prototype.GetBufferIndex = function() {
};
b2ParticleGroup.prototype.GetGroupFlags = function() {
};
b2ParticleGroup.prototype.GetParticleCount = function() {
};
b2ParticleGroup.prototype.SetGroupFlags = function(flags) {
};
/**@constructor*/
function b2ParticleGroupDef() {
this.angle = 0;
this.angularVelocity = 0;
this.color = {};
this.flags = 0;
this.group = {};
this.groupFlags = 0;
this.lifetime = 0.0;
this.linearVelocity = {};
this.position = {};
this.positionData = {};
this.particleCount = 0;
this.shape = {};
this.strength = 1;
this.stride = 0;
this.userData = {};
}
/**@constructor*/
function b2ParticleSystemDef() {
this.colorMixingStrength = 0.5;
this.dampingStrength = 1.0;
this.destroyByAge = true;
this.ejectionStrength = 0.5;
this.elasticStrength = 0.25;
this.lifetimeGranularity = 1.0 / 60.0;
this.powderStrength = 0.5;
this.pressureStrength = 0.05;
this.radius = 1.0;
this.repulsiveStrength = 1.0;
this.springStrength = 0.25;
this.staticPressureIterations = 8;
this.staticPressureRelaxation = 0.2;
this.staticPressureStrength = 0.2;
this.surfaceTensionNormalStrength = 0.2;
this.surfaceTensionPressureStrength = 0.2;
this.viscousStrength = 0.25;
}
/** @constructor */
function b2ParticleSystem(ptr) {
this.dampingStrength = 1.0;
this.density = 1.0;
this.ptr = ptr;
this.particleGroups = [];
this.radius = 1.0;
this.gravityScale = 1.0;
}
b2ParticleSystem.prototype.CreateParticle = function(pd) {
};
b2ParticleSystem.prototype.CreateParticleGroup = function(pgd) {
};
b2ParticleSystem.prototype.DestroyParticlesInShape = function(shape, xf) {
};
b2ParticleSystem.prototype.GetColorBuffer = function() {
};
b2ParticleSystem.prototype.GetParticleLifetime = function(index) {
}
/**@return number*/
b2ParticleSystem.prototype.GetParticleCount = function() {
};
b2ParticleSystem.prototype.GetPositionBuffer = function() {
};
b2ParticleSystem.prototype.GetVelocityBuffer = function() {
};
b2ParticleSystem.prototype.SetDamping = function(damping) {
this.dampingStrength = damping;
};
b2ParticleSystem.prototype.SetDensity = function(density) {
this.density = density;
};
b2ParticleSystem.prototype.SetGravityScale = function(gravityScale) {
this.gravityScale = gravityScale;
};
b2ParticleSystem.prototype.SetMaxParticleCount = function(count) {
};
b2ParticleSystem.prototype.SetParticleLifetime = function(index, lifetime) {
};
b2ParticleSystem.prototype.SetRadius = function(radius) {
this.radius = radius;
};
/**@constructor*/
function b2ChainShape() {
this.radius = b2_polygonRadius;
this.vertices = [];
this.type = b2Shape_Type_e_chain;
}
b2ChainShape.prototype.CreateLoop = function() {
};
// TODO Optimize this
b2ChainShape.prototype._CreateFixture = function(body, fixtureDef) {
};
/**@constructor*/
function b2CircleShape() {
this.position = {};
this.radius = 0;
this.type = b2Shape_Type_e_circle;
}
b2CircleShape.prototype._CreateFixture = function(body, fixtureDef) {
};
b2CircleShape.prototype._CreateParticleGroup = function(particleSystem, pgd) {
};
b2CircleShape.prototype._DestroyParticlesInShape = function(ps, xf) {
};
/** @constructor */
function b2EdgeShape() {
this.hasVertex0 = false;
this.hasVertex3 = false;
this.vertex0 = {};
this.vertex1 = {};
this.vertex2 = {};
this.vertex3 = {};
this.type = b2Shape_Type_e_edge;
}
b2EdgeShape.prototype.Set = function(v1, v2) {
this.vertex1 = v1;
this.vertex2 = v2;
this.hasVertex0 = false;
this.hasVertex3 = false;
};
b2EdgeShape.prototype._CreateFixture = function(body, fixtureDef) {
};
// fixture creation wrappers
// particle group creation wrappers
// particle group destruction wrappers
/** @constructor */
function b2PolygonShape() {
this.position = {};
this.vertices = [];
this.type = b2Shape_Type_e_polygon;
}
b2PolygonShape.prototype.SetAsBoxXY = function(hx, hy) {
this.vertices[0] = {};
this.vertices[1] = {};
this.vertices[2] = {};
this.vertices[3] = {};
};
b2PolygonShape.prototype.SetAsBoxXYCenterAngle = function(hx, hy, center, angle) {
this.vertices[0] = {};
this.vertices[1] = {};
this.vertices[2] = {};
this.vertices[3] = {};
};
b2PolygonShape.prototype._CreateFixture = function(body, fixtureDef) {
};
b2PolygonShape.prototype._CreateParticleGroup = function(particleSystem, pgd) {
};
b2PolygonShape.prototype._DestroyParticlesInShape = function(ps, xf) {
};
/**@return bool*/
b2PolygonShape.prototype.Validate = function() {
}
// Shape constants
var b2Shape_Type_e_circle = 0;
var b2Shape_Type_e_edge = 1;
var b2Shape_Type_e_polygon = 2;
var b2Shape_Type_e_chain = 3;
var b2Shape_Type_e_typeCount = 4;
var b2_linearSlop = 0.005;
var b2_polygonRadius = 1;
var b2_maxPolygonVertices = 8;
function b2MassData(mass, center, I) {
this.mass = mass;
this.center = center;
this.I = I;
}
// TODO this can all be done better, wayyy too manyy calls between asm and js
// a b2contact looks like: (actually this is wrong because of the vtable, I will get a nice one later
/*
uint32 m_flags; // 0
b2Contact* m_prev; // 4
b2Contact* m_next; // 8
b2ContactEdge m_nodeA; // 12 // each of these is 16 bytes, 4 ptrs
b2ContactEdge m_nodeB; // 28
b2Fixture* m_fixtureA; //44
b2Fixture* m_fixtureB; //48
int32 m_indexA;
int32 m_indexB;
b2Manifold m_manifold; a manifold is 20 bytes
int32 m_toiCount;
float32 m_toi;
float32 m_friction;
float32 m_restitution;
float32 m_tangentSpeed;*/
/**@constructor*/
function b2Contact(ptr) {
this.buffer = {};
this.ptr = ptr;
}
b2Contact.prototype.GetFixtureA = function() {
};
b2Contact.prototype.GetFixtureB = function() {
};
b2Contact.prototype.GetManifold = function() {
};
b2Contact.prototype.GetWorldManifold = function() {
};
b2Contact.prototype.SetTangentSpeed = function(speed) {
};
/**@constructor*/
function b2DistanceJoint(def) {
this.bodyA = def.bodyA;
this.bodyB = def.bodyB;
this.ptr = {};
this.next = {};
}
/**@constructor*/
function b2DistanceJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.dampingRatio = 0;
this.length = 1;
this.localAnchorA = {};
this.localAnchorB = {};
this.frequencyHz = 0;
}
b2DistanceJointDef.prototype.Create = function(world) {
};
b2DistanceJointDef.prototype.InitializeAndCreate  = function(bodyA, bodyB, anchorA, anchorB) {
this.bodyA = bodyA;
this.bodyB = bodyB;
};
function b2FrictionJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.localAnchorA = {};
this.localAnchorB = {};
this.maxForce = 0;
this.maxTorque = 0;
this.userData = {};
}
b2FrictionJointDef.prototype.Create = function(world) {
};
b2FrictionJointDef.prototype.InitializeAndCreate  = function(bodyA, bodyB, anchor) {
this.bodyA = bodyA;
this.bodyB = bodyB;
};
function b2FrictionJoint(def) {
this.bodyA = def.bodyA;
this.bodyB = def.bodyB;
this.ptr = {};
this.next = {};
}
function b2GearJoint(def) {
this.ptr = {};
this.next = {};
}
b2GearJoint.prototype.GetRatio = function() {
};
/**@constructor*/
function b2GearJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.joint1 = {};
this.joint2 = {};
this.ratio = 0;
}
b2GearJointDef.prototype.Create = function(world) {
};
var e_unknownJoint = 0;
var e_revoluteJoint = 1;
var e_prismaticJoint = 2;
var e_distanceJoint = 3;
var e_pulleyJoint = 4;
var e_mouseJoint = 5;
var e_gearJoint = 6;
var e_wheelJoint = 7;
var e_weldJoint = 8;
var e_frictionJoint = 9;
var e_ropeJoint = 10;
var e_motorJoint = 11;
/**@constructor*/
function b2Joint() {}
b2Joint.prototype.GetBodyA = function() {
};
b2Joint.prototype.GetBodyB = function() {
};
/**@constructor*/
function b2MotorJoint(def) {
this.bodyA = def.bodyA;
this.bodyB = def.bodyB;
this.ptr = {};
this.next = {};
}
b2MotorJoint.prototype.SetAngularOffset = function(angle) {
};
b2MotorJoint.prototype.SetLinearOffset = function(v) {
};
/**@constructor*/
function b2MotorJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.angularOffset = 0;
this.correctionFactor = 0.3;
this.linearOffset = {};
this.maxForce = 0;
this.maxTorque = 0;
}
b2MotorJointDef.prototype.Create = function(world) {
};
b2MotorJointDef.prototype.InitializeAndCreate  = function(bodyA, bodyB) {
this.bodyA = bodyA;
this.bodyB = bodyB;
};
/**@constructor*/
function b2MouseJoint(def) {
this.ptr = {};
this.next = {};
}
b2MouseJoint.prototype.SetTarget = function(p) {
};
/**@constructor*/
function b2MouseJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.dampingRatio = 0.7;
this.frequencyHz = 5;
this.maxForce = 0;
this.target = {};
}
b2MouseJointDef.prototype.Create = function(world) {
};
/**@constructor*/
function b2PrismaticJoint(def) {
this.ptr = {};
this.next = {};
}
b2PrismaticJoint.prototype = {};
b2PrismaticJoint.prototype.EnableLimit = function(flag) {
};
b2PrismaticJoint.prototype.EnableMotor = function(flag) {
};
b2PrismaticJoint.prototype.GetJointTranslation = function() {
};
b2PrismaticJoint.prototype.GetMotorSpeed = function() {
};
b2PrismaticJoint.prototype.GetMotorForce = function(hz) {
};
b2PrismaticJoint.prototype.IsLimitEnabled = function() {
};
b2PrismaticJoint.prototype.IsMotorEnabled = function() {
};
b2PrismaticJoint.prototype.GetMotorEnabled = function() {
};
b2PrismaticJoint.prototype.SetMotorSpeed = function(speed) {
};
/**@constructor*/
function b2PrismaticJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.enableLimit = false;
this.enableMotor = false;
this.localAnchorA = {};
this.localAnchorB = {};
this.localAxisA = {};
this.lowerTranslation = 0;
this.maxMotorForce = 0;
this.motorSpeed = 0;
this.referenceAngle = 0;
this.upperTranslation = 0;
}
b2PrismaticJointDef.prototype.Create = function(world) {
};
b2PrismaticJointDef.prototype.InitializeAndCreate  = function(bodyA, bodyB, anchor, axis) {
this.bodyA = bodyA;
this.bodyB = bodyB;
};
/**@constructor*/
function b2PulleyJoint(def) {
this.ptr = {};
this.next = {};
}
/**@constructor*/
function b2PulleyJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = true;
this.groundAnchorA = {};
this.groundAnchorB = {};
this.localAnchorA = {};
this.localAnchorB = {};
this.lengthA = 0;
this.lengthB = 0;
this.ratio = 1;
}
b2PulleyJointDef.prototype.Create = function(world) {
};
/** @constructor */
function b2RevoluteJoint(revoluteJointDef) {
this.collideConnected = revoluteJointDef.collideConnected;
this.enableLimit = revoluteJointDef.enableLimit;
this.enableMotor = revoluteJointDef.enableMotor;
this.lowerAngle = revoluteJointDef.lowerAngle;
this.maxMotorTorque = revoluteJointDef.maxMotorTorque;
this.motorSpeed = revoluteJointDef.motorSpeed;
this.next = {};
this.ptr = {};
this.upperAngle = revoluteJointDef.upperAngle;
this.userData = revoluteJointDef.userData;
}
b2RevoluteJoint.prototype = {};
b2RevoluteJoint.prototype.EnableLimit = function(flag) {
};
b2RevoluteJoint.prototype.EnableMotor = function(flag) {
};
b2RevoluteJoint.prototype.GetJointAngle = function(flag) {
};
b2RevoluteJoint.prototype.IsLimitEnabled = function() {
};
b2RevoluteJoint.prototype.IsMotorEnabled = function() {
};
b2RevoluteJoint.prototype.SetMotorSpeed = function(speed) {
this.motorSpeed = speed;
};
/** @constructor */
function b2RevoluteJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.enableLimit = false;
this.enableMotor = false;
this.localAnchorA = {};
this.localAnchorB = {};
this.lowerAngle = 0;
this.maxMotorTorque = 0;
this.motorSpeed = 0;
this.referenceAngle = 0;
this.upperAngle = 0;
this.userData = {};
}
b2RevoluteJointDef.prototype.Create = function(world) {
};
// todo Initialize and create probably shouldnt use the global world ptr
b2RevoluteJointDef.prototype.InitializeAndCreate = function(bodyA, bodyB, anchor) {
this.bodyA = bodyA;
this.bodyB = bodyB;
};
/**@constructor*/
function b2RopeJoint(def) {
this.next = {};
this.ptr = {};
}
/**@constructor*/
function b2RopeJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.localAnchorA = {};
this.localAnchorB = {};
this.maxLength = 0;
}
b2RopeJointDef.prototype.Create = function(world) {
};
/** @constructor */
function b2WeldJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.dampingRatio = 0;
this.frequencyHz = 0;
this.localAnchorA = {};
this.localAnchorB = {};
this.referenceAngle = 0;
}
b2WeldJointDef.prototype.Create = function(world) {
};
b2WeldJointDef.prototype.InitializeAndCreate  = function(bodyA, bodyB, anchor) {
this.bodyA = bodyA;
this.bodyB = bodyB;
};
/** @constructor */
function b2WeldJoint(def) {
this.bodyA = def.bodyA;
this.bodyB = def.bodyB;
this.next = {};
this.ptr = {};
}
// wheel joint globals
/**@constructor*/
function b2WheelJoint(def) {
this.next = {};
this.ptr = {};
}
b2WheelJoint.prototype.SetMotorSpeed = function(speed) {
};
b2WheelJoint.prototype.SetSpringFrequencyHz = function(hz) {
};
// wheeljoint def
/** @constructor*/
function b2WheelJointDef() {
this.bodyA = {};
this.bodyB = {};
this.collideConnected = false;
this.dampingRatio = 0.7;
this.enableMotor = false;
this.frequencyHz = 2;
this.localAnchorA = {};
this.localAnchorB = {};
this.localAxisA = {};
this.maxMotorTorque = 0;
this.motorSpeed = 0;
}
b2WheelJointDef.prototype.Create = function(world) {
};
b2WheelJointDef.prototype.InitializeAndCreate  = function(bodyA, bodyB, anchor, axis) {
this.bodyA = bodyA;
this.bodyB = bodyB;
};
