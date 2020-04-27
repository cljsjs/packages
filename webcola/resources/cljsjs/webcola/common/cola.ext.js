var cola = {
  "BiTangent": function () {},
  "BiTangents": function () {},
  "Block": {
    "createSplitBlock": function () {},
    "split": function () {}
  },
  "Blocks": function () {},
  "Calculator": function () {},
  "Configuration": {
    "getEdges": function () {}
  },
  "Constraint": function () {},
  "ConvexHull": function () {},
  "Descent": {
    "copy": function () {},
    "createSquareMatrix": function () {},
    "dotProd": function () {},
    "mApply": function () {},
    "mid": function () {},
    "rightMultiply": function () {},
    "zeroDistance": {}
  },
  "EventType": {
    "0": {},
    "1": {},
    "2": {},
    "end": {},
    "start": {},
    "tick": {}
  },
  "GridRouter": {
    "angleBetween2Lines": function () {},
    "getOrder": function () {},
    "getRoutePath": function () {},
    "getSegmentSets": function () {},
    "isLeft": function () {},
    "makeSegments": function () {},
    "nudgeSegments": function () {},
    "nudgeSegs": function () {},
    "orderEdges": function () {},
    "unreverseEdges": function () {}
  },
  "IndexedVariable": function () {},
  "Iterator": function () {},
  "LLtangent_PolyPolyC": function () {},
  "LRtangent_PolyPolyC": function () {},
  "Layout": {
    "drag": function () {},
    "dragEnd": function () {},
    "dragOrigin": function () {},
    "dragStart": function () {},
    "getSourceIndex": function () {},
    "getTargetIndex": function () {},
    "linkId": function () {},
    "mouseOut": function () {},
    "mouseOver": function () {},
    "setLinkLength": function () {},
    "stopNode": function () {},
    "storeOffset": function () {}
  },
  "Layout3D": {
    "dims": {},
    "k": {}
  },
  "LayoutAdaptor": {
    "drag": function () {},
    "dragEnd": function () {},
    "dragOrigin": function () {},
    "dragStart": function () {},
    "getSourceIndex": function () {},
    "getTargetIndex": function () {},
    "linkId": function () {},
    "mouseOut": function () {},
    "mouseOver": function () {},
    "setLinkLength": function () {},
    "stopNode": function () {},
    "storeOffset": function () {}
  },
  "LineSegment": function () {},
  "Link3D": function () {},
  "LinkSets": function () {},
  "Locks": function () {},
  "LongestCommonSubsequence": {
    "findMatch": function () {}
  },
  "Module": function () {},
  "ModuleSet": function () {},
  "Node3D": function () {},
  "NodeWrapper": function () {},
  "PairingHeap": function () {},
  "Point": function () {},
  "PolyPoint": function () {},
  "PositionStats": function () {},
  "PowerEdge": function () {},
  "PriorityQueue": function () {},
  "Projection": function () {},
  "PseudoRandom": function () {},
  "RBTree": {
    "double_rotate": function () {},
    "is_red": function () {},
    "single_rotate": function () {}
  },
  "RLtangent_PolyPolyC": function () {},
  "RRtangent_PolyPolyC": function () {},
  "Rectangle": {
    "empty": function () {},
    "lineIntersection": function () {}
  },
  "Solver": {
    "LAGRANGIAN_TOLERANCE": {},
    "ZERO_UPPERBOUND": {}
  },
  "TVGPoint": function () {},
  "TangentVisibilityGraph": function () {},
  "TreeBase": function () {},
  "Variable": function () {},
  "Vert": function () {},
  "VisibilityEdge": function () {},
  "VisibilityVertex": function () {},
  "adaptor": function () {},
  "applyPacking": function () {},
  "clockwiseRadialSweep": function () {},
  "computeGroupBounds": function () {},
  "d3adaptor": function () {},
  "generateDirectedEdgeConstraints": function () {},
  "generateXConstraints": function () {},
  "generateXGroupConstraints": function () {},
  "generateYConstraints": function () {},
  "generateYGroupConstraints": function () {},
  "getGroups": function () {},
  "gridify": function () {},
  "isLeft": function () {},
  "jaccardLinkLengths": function () {},
  "makeEdgeBetween": function () {},
  "makeEdgeTo": function () {},
  "polysOverlap": function () {},
  "powerGraphGridLayout": function () {},
  "removeOverlapInOneDimension": function () {},
  "removeOverlaps": function () {},
  "separateGraphs": function () {},
  "stronglyConnectedComponents": function () {},
  "symmetricDiffLinkLengths": function () {},
  "tangent_PolyPolyC": function () {},
  "tangents": function () {}
};
cola.Block.prototype = {
  "addVariable": function () {},
  "compute_lm": function () {},
  "cost": function () {},
  "findMinLM": function () {},
  "findMinLMBetween": function () {},
  "findPath": function () {},
  "isActiveDirectedPathBetween": function () {},
  "mergeAcross": function () {},
  "populateSplitBlock": function () {},
  "splitBetween": function () {},
  "traverse": function () {},
  "updateWeightedPosition": function () {}
};
cola.Blocks.prototype = {
  "cost": function () {},
  "forEach": function () {},
  "insert": function () {},
  "merge": function () {},
  "remove": function () {},
  "split": function () {},
  "updateBlockPositions": function () {}
};
cola.Calculator.prototype = {
  "DistanceMatrix": function () {},
  "DistancesFromNode": function () {},
  "PathFromNodeToNode": function () {},
  "PathFromNodeToNodeWithPrevCost": function () {},
  "dijkstraNeighbours": function () {}
};
cola.Configuration.prototype = {
  "allEdges": function () {},
  "getGroupHierarchy": function () {},
  "greedyMerge": function () {},
  "initModulesFromGroup": function () {},
  "merge": function () {},
  "nEdges": function () {},
  "rootMerges": function () {}
};
cola.Constraint.prototype = {
  "slack": function () {}
};
cola.Descent.prototype = {
  "computeDerivatives": function () {},
  "computeNextPosition": function () {},
  "computeStepSize": function () {},
  "computeStress": function () {},
  "matrixApply": function () {},
  "offsetDir": function () {},
  "reduceStress": function () {},
  "run": function () {},
  "rungeKutta": function () {},
  "stepAndProject": function () {},
  "takeDescentStep": function () {}
};
cola.GridRouter.prototype = {
  "avg": function () {},
  "findAncestorPathBetween": function () {},
  "findLineage": function () {},
  "getDepth": function () {},
  "getGridLines": function () {},
  "midPoints": function () {},
  "route": function () {},
  "routeEdges": function () {},
  "siblingObstacles": function () {}
};
cola.IndexedVariable.prototype = {
  "constructor": function () {},
  "dfdv": function () {},
  "position": function () {},
  "visitNeighbours": function () {}
};
cola.Iterator.prototype = {
  "_maxNode": function () {},
  "_minNode": function () {},
  "data": function () {},
  "next": function () {},
  "prev": function () {}
};
cola.Layout.prototype = {
  "alpha": function () {},
  "avoidOverlaps": function () {},
  "constraints": function () {},
  "convergenceThreshold": function () {},
  "defaultNodeSize": function () {},
  "distanceMatrix": function () {},
  "flowLayout": function () {},
  "getLinkLength": function () {},
  "getLinkType": function () {},
  "groupCompactness": function () {},
  "groups": function () {},
  "handleDisconnected": function () {},
  "initialLayout": function () {},
  "jaccardLinkLengths": function () {},
  "kick": function () {},
  "linkDistance": function () {},
  "linkType": function () {},
  "links": function () {},
  "nodes": function () {},
  "on": function () {},
  "powerGraphGroups": function () {},
  "prepareEdgeRouting": function () {},
  "resume": function () {},
  "routeEdge": function () {},
  "separateOverlappingComponents": function () {},
  "size": function () {},
  "start": function () {},
  "stop": function () {},
  "symmetricDiffLinkLengths": function () {},
  "tick": function () {},
  "trigger": function () {},
  "updateNodePositions": function () {}
};
cola.Layout3D.prototype = {
  "linkLength": function () {},
  "start": function () {},
  "tick": function () {}
};
cola.LayoutAdaptor.prototype = {
  "alpha": function () {},
  "avoidOverlaps": function () {},
  "constraints": function () {},
  "constructor": function () {},
  "convergenceThreshold": function () {},
  "defaultNodeSize": function () {},
  "distanceMatrix": function () {},
  "drag": function () {},
  "flowLayout": function () {},
  "getLinkLength": function () {},
  "getLinkType": function () {},
  "groupCompactness": function () {},
  "groups": function () {},
  "handleDisconnected": function () {},
  "initialLayout": function () {},
  "jaccardLinkLengths": function () {},
  "kick": function () {},
  "linkDistance": function () {},
  "linkType": function () {},
  "links": function () {},
  "nodes": function () {},
  "on": function () {},
  "powerGraphGroups": function () {},
  "prepareEdgeRouting": function () {},
  "resume": function () {},
  "routeEdge": function () {},
  "separateOverlappingComponents": function () {},
  "size": function () {},
  "start": function () {},
  "stop": function () {},
  "symmetricDiffLinkLengths": function () {},
  "tick": function () {},
  "trigger": function () {},
  "updateNodePositions": function () {}
};
cola.Link3D.prototype = {
  "actualLength": function () {}
};
cola.LinkSets.prototype = {
  "add": function () {},
  "contains": function () {},
  "count": function () {},
  "forAll": function () {},
  "forAllModules": function () {},
  "intersection": function () {},
  "remove": function () {}
};
cola.Locks.prototype = {
  "add": function () {},
  "apply": function () {},
  "clear": function () {},
  "isEmpty": function () {}
};
cola.LongestCommonSubsequence.prototype = {
  "getSequence": function () {}
};
cola.Module.prototype = {
  "getEdges": function () {},
  "isIsland": function () {},
  "isLeaf": function () {},
  "isPredefined": function () {}
};
cola.ModuleSet.prototype = {
  "add": function () {},
  "contains": function () {},
  "count": function () {},
  "forAll": function () {},
  "intersection": function () {},
  "intersectionCount": function () {},
  "modules": function () {},
  "remove": function () {}
};
cola.PairingHeap.prototype = {
  "contains": function () {},
  "count": function () {},
  "decreaseKey": function () {},
  "empty": function () {},
  "forEach": function () {},
  "insert": function () {},
  "isHeap": function () {},
  "merge": function () {},
  "mergePairs": function () {},
  "min": function () {},
  "removeMin": function () {},
  "toString": function () {}
};
cola.PolyPoint.prototype = {
  "constructor": function () {}
};
cola.PositionStats.prototype = {
  "addVariable": function () {},
  "getPosn": function () {}
};
cola.PriorityQueue.prototype = {
  "count": function () {},
  "empty": function () {},
  "forEach": function () {},
  "isHeap": function () {},
  "pop": function () {},
  "push": function () {},
  "reduceKey": function () {},
  "toString": function () {},
  "top": function () {}
};
cola.Projection.prototype = {
  "createAlignment": function () {},
  "createConstraints": function () {},
  "createSeparation": function () {},
  "makeFeasible": function () {},
  "project": function () {},
  "projectFunctions": function () {},
  "setupVariablesAndBounds": function () {},
  "solve": function () {},
  "xProject": function () {},
  "yProject": function () {}
};
cola.PseudoRandom.prototype = {
  "getNext": function () {},
  "getNextBetween": function () {}
};
cola.RBTree.prototype = {
  "_bound": function () {},
  "clear": function () {},
  "constructor": function () {},
  "each": function () {},
  "find": function () {},
  "insert": function () {},
  "iterator": function () {},
  "lowerBound": function () {},
  "max": function () {},
  "min": function () {},
  "reach": function () {},
  "remove": function () {},
  "upperBound": function () {}
};
cola.Rectangle.prototype = {
  "cx": function () {},
  "cy": function () {},
  "height": function () {},
  "inflate": function () {},
  "lineIntersections": function () {},
  "overlapX": function () {},
  "overlapY": function () {},
  "rayIntersection": function () {},
  "setXCentre": function () {},
  "setYCentre": function () {},
  "union": function () {},
  "vertices": function () {},
  "width": function () {}
};
cola.Solver.prototype = {
  "cost": function () {},
  "mostViolated": function () {},
  "satisfy": function () {},
  "setDesiredPositions": function () {},
  "setStartingPositions": function () {},
  "solve": function () {}
};
cola.TVGPoint.prototype = {
  "constructor": function () {}
};
cola.TangentVisibilityGraph.prototype = {
  "addEdgeIfVisible": function () {},
  "addPoint": function () {},
  "intersectsPolys": function () {}
};
cola.TreeBase.prototype = {
  "_bound": function () {},
  "clear": function () {},
  "each": function () {},
  "find": function () {},
  "iterator": function () {},
  "lowerBound": function () {},
  "max": function () {},
  "min": function () {},
  "reach": function () {},
  "upperBound": function () {}
};
cola.Variable.prototype = {
  "dfdv": function () {},
  "position": function () {},
  "visitNeighbours": function () {}
};
cola.VisibilityEdge.prototype = {
  "length": function () {}
};