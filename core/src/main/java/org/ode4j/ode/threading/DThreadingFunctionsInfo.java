/*************************************************************************
 *                                                                       *
 * Open Dynamics Engine, Copyright (C) 2001,2002 Russell L. Smith.       *
 * All rights reserved.  Email: russ@q12.org   Web: www.q12.org          *
 * Open Dynamics Engine 4J, Copyright (C) 2009-2014 Tilmann Zaeschke     *
 * All rights reserved.  Email: ode4j@gmx.de   Web: www.ode4j.org        *
 *                                                                       *
 * This library is free software; you can redistribute it and/or         *
 * modify it under the terms of EITHER:                                  *
 *   (1) The GNU Lesser General Public License as published by the Free  *
 *       Software Foundation; either version 2.1 of the License, or (at  *
 *       your option) any later version. The text of the GNU Lesser      *
 *       General Public License is included with this library in the     *
 *       file LICENSE.TXT.                                               *
 *   (2) The BSD-style license that is included with this library in     *
 *       the file ODE-LICENSE-BSD.TXT and ODE4J-LICENSE-BSD.TXT.         *
 *                                                                       *
 * This library is distributed in the hope that it will be useful,       *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the files    *
 * LICENSE.TXT, ODE-LICENSE-BSD.TXT and ODE4J-LICENSE-BSD.TXT for more   *
 * details.                                                              *
 *                                                                       *
 *************************************************************************/
package org.ode4j.ode.threading;

/**
 * 
 * @author Tilmann Zäschke
 * @Deprecated Not supported in ode4j.
 */
public abstract class DThreadingFunctionsInfo {
	//struct dxThreadingImplementation;
	///typedef struct dxThreadingImplementation *dThreadingImplementationID;

	//typedef unsigned 
	int dmutexindex_t;
//	struct dxMutexGroup;
//	typedef struct dxMutexGroup *dMutexGroupID;
	public interface DMutexGroup {
		
		/**
		 * @brief Deletes a group of muteces.
		 *
		 * @param impl Threading implementation ID
		 * @param mutex_group Mutex group to deallocate
		 *
		 * @ingroup threading
		 * @see dMutexGroupAllocFunction
		 * @see dMutexGroupMutexLockFunction
		 * @see dMutexGroupMutexUnlockFunction
		 */
		void dMutexGroupFreeFunction (DThreadingImplementation impl);

		/**
		 * @brief Locks a mutex in a group of muteces.
		 *
		 * The function is to block execution until requested mutex can be locked.
		 *
		 * Note: Mutex provided may not support recursive locking. Calling this function
		 * while mutex is already locked by current thread will result in unpredictable behavior.
		 *
		 * @param impl Threading implementation ID
		 * @param mutex_group Mutex group to use for locking
		 * @param mutex_index The index of mutex to be locked (0..Mutex_count - 1)
		 *
		 * @ingroup threading
		 * @see dMutexGroupAllocFunction
		 * @see dMutexGroupFreeFunction
		 * @see dMutexGroupMutexUnlockFunction
		 */
		//public void lockFunction (DThreadingImplementation impl, dmutexindex_t mutex_index);
		public void lockFunction (DThreadingImplementation impl, int mutex_index);

		/**
		 * @brief Attempts to lock a mutex in a group of muteces.
		 *
		 * The function is to lock the requested mutex if it is unoccupied or 
		 * immediately return failure if mutex is already locked by other thread.
		 *
		 * Note: Mutex provided may not support recursive locking. Calling this function
		 * while mutex is already locked by current thread will result in unpredictable behavior.
		 *
		 * @param impl Threading implementation ID
		 * @param mutex_group Mutex group to use for locking
		 * @param mutex_index The index of mutex to be locked (0..Mutex_count - 1)
		 * @returns 1 for success (mutex is locked) and 0 for failure (mutex is not locked)
		 *
		 * @ingroup threading
		 * @see dMutexGroupAllocFunction
		 * @see dMutexGroupFreeFunction
		 * @see dMutexGroupMutexLockFunction
		 * @see dMutexGroupMutexUnlockFunction
		 */
		/* typedef int dMutexGroupMutexTryLockFunction (dThreadingImplementationID impl, dMutexGroupID mutex_group, dmutexindex_t mutex_index);*/

		/**
		 * @brief Unlocks a mutex in a group of muteces.
		 *
		 * The function is to unlock the given mutex provided it had been locked before.
		 *
		 * @param impl Threading implementation ID
		 * @param mutex_group Mutex group to use for unlocking
		 * @param mutex_index The index of mutex to be unlocked (0..Mutex_count - 1)
		 *
		 * @ingroup threading
		 * @see dMutexGroupAllocFunction
		 * @see dMutexGroupFreeFunction
		 * @see dMutexGroupMutexLockFunction
		 */
		//void unlockFunction (DThreadingImplementation impl, dmutexindex_t mutex_index);
		void unlockFunction (DThreadingImplementation impl, int mutex_index);
	}

	/**
	 * @brief Allocates a group of muteces.
	 *
	 * The Mutex allocated do not need to support recursive locking.
	 *
	 * The Mutex names are provided to aid in debugging and thread state tracking.
	 *
	 * @param impl Threading implementation ID
	 * @param Mutex_count Number of Mutex to create
	 * @Mutex_names_ptr Pointer to optional Mutex names array to be associated with individual Mutex
	 * @returns MutexGroup ID or NULL if error occurred.
	 *
	 * @ingroup threading
	 * @see dMutexGroupFreeFunction
	 * @see dMutexGroupMutexLockFunction
	 * @see dMutexGroupMutexUnlockFunction
	 * @Deprecated: Should be part of DMutexGroup
	 */
	//static DMutexGroup dMutexGroupAllocFunction (DThreadingImplementation impl, 
	//dmutexindex_t Mutex_count, const char *const *Mutex_names_ptr/*=NULL*/);
	static DMutexGroup dMutexGroupAllocFunction (DThreadingImplementation impl, 
			int Mutex_count, String Mutex_names_ptr/*=NULL*/) {
		throw new UnsupportedOperationException();
	}



	//struct dxCallReleasee;
	//typedef struct dxCallReleasee *dCallReleaseeID;
	public interface DCallReleasee {
		
	}

	/**
	 * @brief Allocates a Wait ID that can be used to wait for a call.
	 *
	 * @param impl Threading implementation ID
	 * @returns Wait ID or NULL if error occurred
	 *
	 * @ingroup threading
	 * @see dThreadedCallWaitResetFunction
	 * @see dThreadedCallWaitFreeFunction
	 * @see dThreadedCallPostFunction
	 * @see dThreadedCallWaitFunction
	 * @deprecated should be part of DCallWait (TZ)
	 */
	public static DCallWait callWaitAllocFunction(DThreadingImplementation impl) {
		throw new UnsupportedOperationException();
	}

	//struct dxCallWait;
	public interface DCallWait {

		/**
		 * @brief Resets a Wait ID so that it could be used to wait for another call.
		 *
		 * @param impl Threading implementation ID
		 * @param call_wait Wait ID to reset
		 *
		 * @ingroup threading
		 * @see dThreadedCallWaitAllocFunction
		 * @see dThreadedCallWaitFreeFunction
		 * @see dThreadedCallPostFunction
		 * @see dThreadedCallWaitFunction
		 */
		void resetFunction(DThreadingImplementation impl);

		/**
		 * @brief Frees a Wait ID.
		 *
		 * @param impl Threading implementation ID
		 * @param call_wait Wait ID to delete
		 *
		 * @ingroup threading
		 * @see dThreadedCallWaitAllocFunction
		 * @see dThreadedCallPostFunction
		 * @see dThreadedCallWaitFunction
		 */
		void freeFunction(DThreadingImplementation impl);
	};

	//typedef size_t 
	int ddependencycount_t;
	//typedef ptrdiff_t 
	int ddependencychange_t;
	//typedef size_t 
	int dcallindex_t;
	//typedef int dThreadedCallFunction(void *call_context, dcallindex_t instance_index, 
	//  dCallReleaseeID this_releasee);
	interface DThreadedCallFunction {
		int f(Object[][] call_context, int instance_index, 
				DCallReleasee this_releasee);
	}
	
	
	static class DxThreadedWaitTime
	{
	  //time_t    wait_sec;
	  int	   	wait_sec;
	  long   	wait_nsec;

	};
	
	interface DThreadedWaitTime {
		
	};




	/**
	 * @brief Post a function to be called in another thread.
	 *
	 * A call is scheduled to be executed asynchronously.
	 *
	 * A @a out_summary_fault variable can be provided for call to accumulate any
	 * possible faults from its execution and execution of any possible sub-calls.
	 * This variable gets result that @a call_func returns. Also, if dependent calls 
	 * are executed after the call already exits, the variable is also going to be 
	 * updated with results of all those calls before control is released to master.
	 *
	 * @a out_post_releasee parameter receives a value of @c dCallReleaseeID that can 
	 * later be used for @a dependent_releasee while scheduling sub-calls to make 
	 * current call depend on them. The value is only returned if @a dependencies_count 
	 * is not zero (i.e. if any dependencies are expected at all). The call is not going 
	 * to start until all its dependencies complete.
	 *
	 * In case if number of dependencies is unknown in advance 1 can be passed on call
	 * scheduling. Then @c dThreadedCallDependenciesCountAlterFunction can be used to
	 * add one more extra dependencies before scheduling each subcall. And then, after
	 * all sub-calls had been scheduled, @c dThreadedCallDependenciesCountAlterFunction
	 * can be used again to subtract initial extra dependency from total number.
	 * Adding one dependency in advance is necessary to obtain releasee ID and to make 
	 * sure the call will not start and will not terminate before all sub-calls are scheduled.
	 *
	 * Extra dependencies can also be added from the call itself after it has already 
	 * been started (with parameter received in @c dThreadedCallFunction). 
	 * In that case those dependencies will start immediately or after call returns 
	 * but the call's master will not be released/notified until all additional
	 * dependencies complete. This can be used to schedule sub-calls from a call and 
	 * then pass own job to another sub-call dependent on those initial sub-calls.
	 *
	 * By using @ call_wait it is possible to assign a Wait ID that can later 
	 * be passed into @c dThreadedCallWaitFunction to wait for call completion.
	 *
	 * If @a call_name is available (and it should!) the string must remain valid until
	 * after call completion. In most cases this should be a static string literal.
	 * 
	 * Since the function is an analogue of normal method call it is not supposed to fail.
	 * Any complications with resource allocation on call scheduling should be 
	 * anticipated, avoided and worked around by implementation.
	 *
	 * @param impl Threading implementation ID
	 * @param out_summary_fault Optional pointer to variable to be set to 1 if function 
	 *        call (or any sub-call) fails internally, or 0 if all calls return success
	 * @param out_post_releasee Optional pointer to variable to receive releasee ID 
	 *        associated with the call
	 * @param dependencies_count Number of dependencies that are going to reference
	 *        this call as dependent releasee
	 * @param dependent_releasee Optional releasee ID to reference with this call
	 * @param call_wait Optional Wait ID that can later be used to wait for the call
	 * @param call_func Pointer to function to be called
	 * @param call_context Context parameter to be passed into the call
	 * @param instance_index Index parameter to be passed into the call
	 * @param call_name Optional name to be associated with the call (for debugging and state tracking)
	 *
	 * @ingroup threading
	 * @see dThreadedCallWaitFunction
	 * @see dThreadedCallDependenciesCountAlterFunction
	 * @see dThreadingImplResourcesForCallsPreallocateFunction
	 */
	abstract void callPostFunction(DThreadingImplementation impl, int[][] out_summary_fault/*=NULL*/, 
	  DCallReleasee out_post_releasee/*=NULL*/, //ddependencycount_t dependencies_count, dCallReleaseeID dependent_releasee/*=NULL*/, 
	  int dependencies_count, DCallReleasee dependent_releasee/*=NULL*/,
	  DCallWait call_wait/*=NULL*/, 
	  DThreadedCallFunction call_func, Object [][]call_context, //dcallindex_t instance_index, 
	  int instance_index,
	  String call_name/*=NULL*/);

	/**
	 * @brief Add or remove extra dependencies from call that has been scheduled
	 * or is in process of execution.
	 *
	 * Extra dependencies can be added to a call if exact number of sub-calls is
	 * not known in advance at the moment the call is scheduled. Also, some dependencies
	 * can be removed if sub-calls were planned but then dropped. 
	 *
	 * In case if total dependency count of a call reaches zero by result of invoking 
	 * this function, the call is free to start executing immediately.
	 *
	 * After the call execution had been started, any additional dependencies can only
	 * be added from the call function itself!
	 *
	 * @param impl Threading implementation ID
	 * @param target_releasee ID of releasee to apply dependencies count change to
	 * @param dependencies_count_change Number of dependencies to add or remove
	 *
	 * @ingroup threading
	 * @see dThreadedCallPostFunction
	 */
	abstract void callDependenciesCountAlterFunction(DThreadingImplementation impl, 
			DCallReleasee target_releasee, 
	  //ddependencychange_t dependencies_count_change);
			int dependencies_count_change);

	/**
	 * @brief Wait for a posted call to complete.
	 *
	 * Function blocks until a call identified by @a call_wait completes or
	 * timeout elapses.
	 *
	 * IT IS ILLEGAL TO INVOKE THIS FUNCTION FROM WITHIN A THREADED CALL!
	 * This is because doing so will block a physical thread and will require 
	 * increasing worker thread count to avoid starvation. Use call dependencies 
	 * if it is necessary make sure sub-calls have been completed instead!
	 *
	 * If @a timeout_time_ptr is NULL, the function waits without time limit. If @a timeout_time_ptr
	 * points to zero value, the function only checks status and does not block.
	 *
	 * If @a wait_name is available (and it should!) the string must remain valid for
	 * the duration of wait. In most cases this should be a static string literal.
	 * 
	 * Function is not expected to return failures caused by system call faults as 
	 * those are hardly ever possible to be handled in this case anyway. In event of 
	 * system call fault the function is supposed to terminate application.
	 *
	 * @param impl Threading implementation ID
	 * @param out_wait_status Optional pointer to variable to receive 1 if waiting succeeded
	 *        or 0 in case of timeout
	 * @param call_wait Wait ID that had been passed to scheduling a call that needs to be waited for
	 * @param timeout_time_ptr Optional pointer to time specification the wait must not
	 *        last longer than (pass NULL for infinite timeout)
	 * @param wait_name Optional name to be associated with the wait (for debugging and state tracking)
	 *
	 * @ingroup threading
	 * @see dThreadedCallPostFunction
	 */
	abstract void callWaitFunction(DThreadingImplementation impl, int [][]out_wait_status/*=NULL*/, 
	  DCallWait call_wait, final DThreadedWaitTime [][]timeout_time_ptr/*=NULL*/, 
	  String wait_name/*=NULL*/);

	/**
	 * @brief Retrieve number of active threads that serve the implementation.
	 *
	 * @param impl Threading implementation ID
	 * @returns Number of active threads
	 *
	 * @ingroup threading
	 */
	abstract int dThreadingImplThreadCountRetrieveFunction(DThreadingImplementation impl);

	/**
	 * @brief Preallocate resources to handle posted calls.
	 *
	 * The function is intended to make sure enough resources is preallocated for the
	 * implementation to be able to handle posted calls. Then @c max_simultaneous_calls_estimate
	 * is an estimate of how many posted calls can potentially be active or scheduled 
	 * at the same time. The value is usually derived from the way the calls are posted 
	 * in library code and dependencies between them.
	 * 
	 * @warning While working on an implementation be prepared that the estimate provided 
	 * yet rarely but theoretically can be exceeded due to unpredictability of thread execution.
	 *
	 * This function is normally going to be invoked by library each time it is entered
	 * from outside to do the job but before any threaded calls are going to be posted.
	 *
	 * @param impl Threading implementation ID
	 * @param max_simultaneous_calls_estimate An estimated number of calls that can be posted simultaneously
	 * @returns 1 or 0 to indicate success or failure
	 *
	 * @ingroup threading
	 * @see dThreadedCallPostFunction
	 */
	abstract int dThreadingImplResourcesForCallsPreallocateFunction(DThreadingImplementation impl, 
	  //ddependencycount_t max_simultaneous_calls_estimate);
			int max_simultaneous_calls_estimate);


	/**
	 * @brief An interface structure with function pointers to be provided by threading implementation.
	 */
	static class DxThreadingFunctionsInfo
	{
	  int struct_size;
	  
//	  dMutexGroupAllocFunction []alloc_mutex_group;
//	  dMutexGroupFreeFunction []free_mutex_group;
//	  dMutexGroupMutexLockFunction []lock_group_mutex;
//	  dMutexGroupMutexUnlockFunction []unlock_group_mutex;
//
//	  dThreadedCallWaitAllocFunction []alloc_call_wait;
//	  dThreadedCallWaitResetFunction []reset_call_wait;
//	  dThreadedCallWaitFreeFunction []free_call_wait;
//
//	  dThreadedCallPostFunction []post_call;
//	  dThreadedCallDependenciesCountAlterFunction []alter_call_dependencies_count;
//	  dThreadedCallWaitFunction []wait_call;
//
//	  dThreadingImplThreadCountRetrieveFunction []retrieve_thread_count;
//	  dThreadingImplResourcesForCallsPreallocateFunction []preallocate_resources_for_calls; 

	  /* 
	   * Beware of Jon Watte's anger if you dare to uncomment this!
	   * May cryptic text below be you a warning!
	   * Ð¡Ñ‚Ð°Ñ€Ð¾Ð´Ð°Ð²Ð½Ñ– Ð»ÐµÐ³ÐµÐ½Ð´Ð¸ Ñ€Ð¾Ð·ÐºÐ°Ð·ÑƒÑŽÑ‚ÑŒ, Ñ‰Ð¾ ÐºÐ¾Ð¶Ð½Ð¾Ð³Ð¾ Ñ�Ð¼Ñ–Ð»Ð¸Ð²Ñ†Ñ�, Ñ…Ñ‚Ð¾ Ð½Ð°Ð²Ð°Ð¶Ð¸Ñ‚ÑŒÑ�Ñ� Ð¿Ð¾Ñ€ÑƒÑˆÐ¸Ñ‚Ð¸ Ñ‚Ð°Ð±Ñƒ 
	   * Ñ– Ð²Ñ–Ð´ÐºÑ€Ð¸Ñ‚Ð¸ Ð·Ð°Ð±Ð¾Ñ€Ð¾Ð½ÐµÐ½Ð¸Ð¹ ÐºÐ¾Ð´, Ñ�Ð¿Ñ–Ñ‚ÐºÐ°Ñ” Ñ�Ñ‚Ñ€Ð°ÑˆÐ½Ðµ Ð¿Ñ€Ð¾ÐºÐ»Ñ�Ñ‚Ñ‚Ñ� Ñ– Ð²Ñ–Ð½ Ð²Ñ–Ð´Ñ€Ð°Ð·Ñƒ Ð¿Ð¾Ñ‡Ð½Ðµ Ñ€Ð¾Ð±Ð¸Ñ‚Ð¸ 
	   * Ð¾Ð´Ð½Ñ– Ð»Ð¸Ñˆ Ð¿Ð¾Ð¼Ð¸Ð»ÐºÐ¸.
	   *
	   * dMutexGroupMutexTryLockFunction *trylock_group_mutex;
	   */

	} 
	
//	public interface DThreadingFunctionsInfo {
//		
//	};

}
