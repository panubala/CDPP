  # Emitting class Main {...}
    # Emitting void main(...) {...}
.globl _main
_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting x = (5 + 1)
          # Emitting x
          # Emitting (5 + 1)
            # Emitting 5
            movl $5, %esi
            # Emitting 1
            movl $1, %edx
          pushl %esi
          pushl %edx
          movl 4(%esp), %esi
          addl 0(%esp), %esi
        movl %esi, %edi
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
