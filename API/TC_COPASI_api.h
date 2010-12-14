#ifndef TINKERCELL_TC_COPASI_API_H
#define TINKERCELL_TC_COPASI_API_H

#include "TC_structs.h"
BEGIN_C_DECLS


/*! 
 \brief simulate using LSODA numerical integrator
  \param double start time
 \param double end time
 \param int number of steps in the output
 \return tc_matrix matrix of concentration or particles
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix simulateDeterministic(double startTime, double endTime, int numSteps);
/*! 
 \brief simulate using exact stochastic algorithm
  \param double start time
 \param double end time
 \param int number of steps in the output
 \return tc_matrix matrix of concentration or particles
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix simulateStochastic(double startTime, double endTime, int numSteps);
/*! 
 \brief simulate using Hybrid algorithm/deterministic algorithmparam double start time
 \param double end time
 \param int number of steps in the output
 \return tc_matrix matrix of concentration or particles
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix simulateHybrid(double startTime, double endTime, int numSteps);
/*! 
 \brief simulate using Tau Leap stochastic algorithm
 \param double start time
 \param double end time
 \param int number of steps in the output
 \return tc_matrix matrix of concentration or particles
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix simulateTauLeap(double startTime, double endTime, int numSteps);

/*! 
 \brief bring the system to steady state
 \return tc_matrix matrix with 1 row and n columns, where n = number of species
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix getSteadyState();

/*! 
 \brief calculate steady state for each value of a parameter
 \param char * parameter name
  \param double start value
 \param double end value
 \param int number of steps in the output
 \return tc_matrix matrix of concentration or particles
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix steadyStateScan(const char * param, double start, double end, int numSteps);

/*! 
 \brief calculate steady state for each value of two parameters
 \param char * first parameter name
  \param double start value for parameter 1
 \param double end value for parameter 1
  \param int number of steps in parameter 1
  \param char * second parameter name
  \param double start value for parameter 2
 \param double end value for parameter 2
 \param int number of steps in parameter 2
 \return tc_matrix matrix of concentration or particles
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix steadyStateScan2D(const char * param1, double start1, double end1, int numSteps1,
																			const char * param2, double start2, double end2, int numSteps2);

/*! 
 \brief get the Jacobian at the current state
 \return tc_matrix matrix with n rows and n columns, where n = number of species
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix getJacobian();
/*! 
 \brief get the eigenvalues of the Jacobian at the current state
 \return tc_matrix matrix with 1 row and n columns, each containing an eigenvalue
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix getEigenvalues();

/*! 
 \brief unscaled elasticities
 \return tc_matrix 
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix getUnscaledElasticities();

/*! unscaled concentration control coefficients
 \brief unscaled elasticities
 \return tc_matrix 
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix getUnscaledConcentrationCC();

/*! 
 \brief unscaled flux control coefficients
 \return tc_matrix 
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix getUnscaledFluxCC();

/*! 
 \brief scaled elasticities
 \return tc_matrix 
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix getScaledElasticities();

/*! 
 \brief scaled concentration control coefficients
 \return tc_matrix 
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix getScaledConcentrationCC();

/*! 
 \brief scaled flux control coefficients
 \return tc_matrix 
 \ingroup Simulation
*/
TCAPIEXPORT tc_matrix getScaledFluxCC();

/*!
 \brief initializing function
 \ingroup init
*/
TCAPIEXPORT void tc_COPASI_api(
tc_matrix (*simulateDeterministic)(double startTime, double endTime, int numSteps),
tc_matrix (*simulateStochastic)(double startTime, double endTime, int numSteps),
tc_matrix (*simulateHybrid)(double startTime, double endTime, int numSteps),
tc_matrix (*simulateTauLeap)(double startTime, double endTime, int numSteps),
tc_matrix (*getSteadyState)(),
tc_matrix (*steadyStateScan)(const char * param, double start, double end, int numSteps),
tc_matrix (*steadyStateScan2D)(const char * param1, double start1, double end1, int numSteps1,const char * param2, double start2, double end2, int numSteps2),
tc_matrix (*getJacobian)(),
tc_matrix (*getEigenvalues)(),
tc_matrix (*getUnscaledElasticities)(),
tc_matrix (*getUnscaledConcentrationCC)(),
tc_matrix (*getUnscaledFluxCC)(),
tc_matrix (*getScaledElasticities)(),
tc_matrix (*getScaledConcentrationCC)(),
tc_matrix (*getScaledFluxCC)()
);

END_C_DECLS
#endif
